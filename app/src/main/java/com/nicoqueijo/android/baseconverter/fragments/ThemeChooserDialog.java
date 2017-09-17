package com.nicoqueijo.android.baseconverter.fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nicoqueijo.android.baseconverter.activities.MainActivity;
import com.nicoqueijo.android.baseconverter.R;
import com.nicoqueijo.android.baseconverter.interfaces.Communicator;

import java.util.Stack;

/**
 * Class for the dialog fragment window that lets the user change theme.
 */
public class ThemeChooserDialog extends DialogFragment {

    private Communicator mCommunicator;
    private SharedPreferences mSharedPreferences;
    private Stack<ImageView> mActiveCheckedTheme = new Stack<>();

    private ImageView mThemeOptionPurple;
    private ImageView mThemeOptionIndigo;
    private ImageView mThemeOptionPink;
    private ImageView mThemeOptionTeal;
    private ImageView mThemeOptionGreen;
    private ImageView mThemeOptionOrange;
    private ImageView mCheckBoxPurple;
    private ImageView mCheckBoxIndigo;
    private ImageView mCheckBoxPink;
    private ImageView mCheckBoxTeal;
    private ImageView mCheckBoxGreen;
    private ImageView mCheckBoxOrange;
    private TextView mThemeTextView;
    private Button mCancelButton;

    /**
     * Empty constructor required for DialogFragment.
     */
    public ThemeChooserDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_theme_chooser, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSharedPreferences = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        removeTitleBar();

        mThemeOptionPurple = (ImageView) view.findViewById(R.id.option_theme_purple);
        mThemeOptionIndigo = (ImageView) view.findViewById(R.id.option_theme_indigo);
        mThemeOptionPink = (ImageView) view.findViewById(R.id.option_theme_pink);
        mThemeOptionTeal = (ImageView) view.findViewById(R.id.option_theme_teal);
        mThemeOptionGreen = (ImageView) view.findViewById(R.id.option_theme_green);
        mThemeOptionOrange = (ImageView) view.findViewById(R.id.option_theme_orange);
        mCheckBoxPurple = (ImageView) view.findViewById(R.id.check_mark_purple);
        mCheckBoxIndigo = (ImageView) view.findViewById(R.id.check_mark_indigo);
        mCheckBoxPink = (ImageView) view.findViewById(R.id.check_mark_pink);
        mCheckBoxTeal = (ImageView) view.findViewById(R.id.check_mark_teal);
        mCheckBoxGreen = (ImageView) view.findViewById(R.id.check_mark_green);
        mCheckBoxOrange = (ImageView) view.findViewById(R.id.check_mark_orange);
        mThemeTextView = (TextView) view.findViewById(R.id.label_theme);
        mCancelButton = (Button) view.findViewById(R.id.button_cancel);

        restoreSavedCheckedTheme();
        setCustomFont();

        mThemeOptionPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndSaveTheme(mCheckBoxPurple, R.style.AppThemePurple);
            }
        });

        mThemeOptionIndigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndSaveTheme(mCheckBoxIndigo, R.style.AppThemeIndigo);
            }
        });

        mThemeOptionPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndSaveTheme(mCheckBoxPink, R.style.AppThemePink);
            }
        });

        mThemeOptionTeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndSaveTheme(mCheckBoxTeal, R.style.AppThemeTeal);
            }
        });

        mThemeOptionGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndSaveTheme(mCheckBoxGreen, R.style.AppThemeGreen);
            }
        });

        mThemeOptionOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAndSaveTheme(mCheckBoxOrange, R.style.AppThemeOrange);
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    /**
     * Attaches this DialogFragment to its hosting Activity.
     *
     * @param activity the Activity hosting this DialogFragment.
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCommunicator = (Communicator) activity;
    }


    /**
     * Changes the checked theme to the selected theme, saves the selected theme to SharedPreferences,
     * and sends a message back to the hosting activity so the layout can be updated with the new
     * theme.
     *
     * @param checkImage the ImageView of the check mark that corresponds to the selected theme.
     * @param themeId    the theme id of the theme that was selected.
     */
    private void setAndSaveTheme(ImageView checkImage, int themeId) {
        if (!mActiveCheckedTheme.isEmpty()) {
            mActiveCheckedTheme.pop().setVisibility(View.INVISIBLE);
        }
        checkImage.setVisibility(View.VISIBLE);
        mActiveCheckedTheme.push(checkImage);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt("theme", themeId);
        editor.commit();
        mCommunicator.onDialogMessage("theme");
        dismiss();
    }

    /**
     * Retrieves the theme setting from the SharedPreferences file and sets the check mark of that
     * theme visible. If this is the first time running the app SharedPreferences won't have a theme
     * value and the default will purple.
     */
    private void restoreSavedCheckedTheme() {
        int savedTheme = mSharedPreferences.getInt("theme", R.style.AppThemePurple);
        if (savedTheme == R.style.AppThemeIndigo) {
            mCheckBoxIndigo.setVisibility(View.VISIBLE);
            mActiveCheckedTheme.push(mCheckBoxIndigo);
        } else if (savedTheme == R.style.AppThemePink) {
            mCheckBoxPink.setVisibility(View.VISIBLE);
            mActiveCheckedTheme.push(mCheckBoxPink);
        } else if (savedTheme == R.style.AppThemeTeal) {
            mCheckBoxTeal.setVisibility(View.VISIBLE);
            mActiveCheckedTheme.push(mCheckBoxTeal);
        } else if (savedTheme == R.style.AppThemeGreen) {
            mCheckBoxGreen.setVisibility(View.VISIBLE);
            mActiveCheckedTheme.push(mCheckBoxGreen);
        } else if (savedTheme == R.style.AppThemeOrange) {
            mCheckBoxOrange.setVisibility(View.VISIBLE);
            mActiveCheckedTheme.push(mCheckBoxOrange);
        } else {
            mCheckBoxPurple.setVisibility(View.VISIBLE);
            mActiveCheckedTheme.push(mCheckBoxPurple);
        }
    }

    /**
     * Removes title bar from dialog fragment that is displayed on older API versions.
     */
    private void removeTitleBar() {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * Sets the dialog title and cancel button to the custom font in bold.
     */
    private void setCustomFont() {
        mThemeTextView.setTypeface(MainActivity.mCustomFontSemiBold);
        mCancelButton.setTypeface(MainActivity.mCustomFontSemiBold);
    }
}
