package com.nicoqueijo.android.baseconverter.activities;

import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nicoqueijo.android.baseconverter.helpers.CustomTypefaceSpan;
import com.nicoqueijo.android.baseconverter.R;
import com.nicoqueijo.android.baseconverter.helpers.SystemInfo;
import com.nicoqueijo.android.baseconverter.algorithms.BaseConverter;
import com.nicoqueijo.android.baseconverter.fragments.LanguageChooserDialog;
import com.nicoqueijo.android.baseconverter.fragments.ThemeChooserDialog;
import com.nicoqueijo.android.baseconverter.interfaces.Communicator;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Android application. Converts numbers from one base to another supporting base 2 through 16.
 * Implements Communicator in order to be notified when the language or theme has changed.
 */
public class MainActivity extends AppCompatActivity implements Communicator {

    public static final String DEVELOPER_GITHUB_URL = "https://github.com/nicoqueijo";
    public static final String EXO_2_SEMIBOLD_FONT_PATH = "fonts/Exo2-SemiBold.ttf";
    public static final String EXO_2_REGULAR_FONT_PATH = "fonts/Exo2-Regular.ttf";

    private final int SEEKBAR_FROM_START_LOCATION = 8;
    private final int SEEKBAR_TO_START_LOCATION = 0;
    private final int SEEKBAR_BUTTON_OFFSET = 1;
    private final int SEEKBAR_PROGRESS_OFFSET = 2;

    private final int BASE_2 = 2;
    private final int BASE_3 = 3;
    private final int BASE_4 = 4;
    private final int BASE_5 = 5;
    private final int BASE_6 = 6;
    private final int BASE_7 = 7;
    private final int BASE_8 = 8;
    private final int BASE_9 = 9;
    private final int BASE_10 = 10;
    private final int BASE_11 = 11;
    private final int BASE_12 = 12;
    private final int BASE_13 = 13;
    private final int BASE_14 = 14;
    private final int BASE_15 = 15;
    private final int BASE_16 = 16;

    private final Character CHAR_0 = '0';
    private final Character CHAR_1 = '1';
    private final Character CHAR_2 = '2';
    private final Character CHAR_3 = '3';
    private final Character CHAR_4 = '4';
    private final Character CHAR_5 = '5';
    private final Character CHAR_6 = '6';
    private final Character CHAR_7 = '7';
    private final Character CHAR_8 = '8';
    private final Character CHAR_9 = '9';
    private final Character CHAR_A = 'A';
    private final Character CHAR_B = 'B';
    private final Character CHAR_C = 'C';
    private final Character CHAR_D = 'D';
    private final Character CHAR_E = 'E';
    private final Character CHAR_F = 'F';

    private int mCurrentSeekbarFromProgress = SEEKBAR_FROM_START_LOCATION;
    private int mCurrentSeekbarToProgress = SEEKBAR_TO_START_LOCATION;

    private ActionBar mActionBar;
    private FragmentManager mFragmentManager = getFragmentManager();
    private SharedPreferences mSharedPreferences;

    private SeekBar mSeekBarFrom;
    private SeekBar mSeekBarTo;

    private TextView mFromLabel;
    private TextView mToLabel;
    private TextView mInputLabel;
    private TextView mOutputLabel;
    private TextView mBaseToLabel;
    private TextView mBaseFromLabel;
    private TextView mBaseFromNumberLabel;
    private TextView mBaseToNumberLabel;

    private TextView mInputValueLabel;
    private TextView mOutputValueLabel;

    private Button mButton0;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButtonA;
    private Button mButtonB;
    private Button mButtonC;
    private Button mButtonD;
    private Button mButtonE;
    private Button mButtonF;
    private Button mButtonDel;
    private Button mButtonClr;

    private Button[] mButtonsArray;
    private View[] mAllViewsArray;

    private ArrayList<Character> mUserInput = new ArrayList<>();
    public static Typeface mCustomFontSemiBold;
    public static Typeface mCustomFontRegular;

    private Toast mOverflowToast = null;
    private ClipboardManager mClipboardManager;
    private ClipData mClipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        setLocale(mSharedPreferences.getString("language", SystemInfo.SYSTEM_LOCALE));
        setTheme(mSharedPreferences.getInt("theme", R.style.AppThemePurple));
        if (SystemInfo.isRunningLollipopOrHigher()) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_main_static_theme);
        }

        mCustomFontSemiBold = Typeface.createFromAsset(getAssets(), EXO_2_SEMIBOLD_FONT_PATH);
        mCustomFontRegular = Typeface.createFromAsset(getAssets(), EXO_2_REGULAR_FONT_PATH);
        mClipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        SpannableString titleWithCustomFont = new SpannableString(getString(R.string.title));
        titleWithCustomFont.setSpan(new CustomTypefaceSpan("", mCustomFontSemiBold), 0,
                titleWithCustomFont.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(true);
        mActionBar.setIcon(R.mipmap.ic_launcher);
        mActionBar.setTitle(titleWithCustomFont);

        mSeekBarFrom = (SeekBar) findViewById(R.id.seekbar_from_controller);
        mSeekBarTo = (SeekBar) findViewById(R.id.seekbar_to_controller);

        mFromLabel = (TextView) findViewById(R.id.from_label);
        mToLabel = (TextView) findViewById(R.id.to_label);
        mInputLabel = (TextView) findViewById(R.id.input_label);
        mOutputLabel = (TextView) findViewById(R.id.output_label);
        mBaseFromLabel = (TextView) findViewById(R.id.base_label_from);
        mBaseToLabel = (TextView) findViewById(R.id.base_label_to);
        mBaseFromNumberLabel = (TextView) findViewById(R.id.base_from_number_label);
        mBaseToNumberLabel = (TextView) findViewById(R.id.base_to_number_label);

        mInputValueLabel = (TextView) findViewById(R.id.input_value);
        mOutputValueLabel = (TextView) findViewById(R.id.output_value);

        mButton0 = (Button) findViewById(R.id.button_0);
        mButton1 = (Button) findViewById(R.id.button_1);
        mButton2 = (Button) findViewById(R.id.button_2);
        mButton3 = (Button) findViewById(R.id.button_3);
        mButton4 = (Button) findViewById(R.id.button_4);
        mButton5 = (Button) findViewById(R.id.button_5);
        mButton6 = (Button) findViewById(R.id.button_6);
        mButton7 = (Button) findViewById(R.id.button_7);
        mButton8 = (Button) findViewById(R.id.button_8);
        mButton9 = (Button) findViewById(R.id.button_9);
        mButtonA = (Button) findViewById(R.id.button_A);
        mButtonB = (Button) findViewById(R.id.button_B);
        mButtonC = (Button) findViewById(R.id.button_C);
        mButtonD = (Button) findViewById(R.id.button_D);
        mButtonE = (Button) findViewById(R.id.button_E);
        mButtonF = (Button) findViewById(R.id.button_F);
        mButtonDel = (Button) findViewById(R.id.button_del);
        mButtonClr = (Button) findViewById(R.id.button_clr);

        mButtonsArray = new Button[]{
                mButton0, mButton1, mButton2, mButton3,
                mButton4, mButton5, mButton6, mButton7,
                mButton8, mButton9, mButtonA, mButtonB,
                mButtonC, mButtonD, mButtonE, mButtonF
        };

        mAllViewsArray = new View[]{
                mFromLabel, mToLabel, mInputLabel, mOutputLabel, mBaseToLabel, mBaseFromLabel,
                mBaseToNumberLabel, mBaseFromNumberLabel, mInputValueLabel, mOutputValueLabel,
                mButton0, mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7,
                mButton8, mButton9, mButtonA, mButtonB, mButtonC, mButtonD, mButtonE, mButtonF,
                mButtonDel, mButtonClr
        };

        setCustomFont();

        mSeekBarFrom.setProgress(SEEKBAR_FROM_START_LOCATION);
        mSeekBarTo.setProgress(SEEKBAR_TO_START_LOCATION);

        /**
         * Enables/disables buttons according to the position of the from-seekbar.
         * Also resets the current input if from-seekbar moves.
         */
        mSeekBarFrom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCurrentSeekbarFromProgress = progress;
                mBaseFromNumberLabel.setText(String.valueOf(mCurrentSeekbarFromProgress
                        + SEEKBAR_PROGRESS_OFFSET));
                for (int i = 0; i < mButtonsArray.length; i++) {
                    if (i <= progress + SEEKBAR_BUTTON_OFFSET) {
                        mButtonsArray[i].setVisibility(View.VISIBLE);
                    } else {
                        mButtonsArray[i].setVisibility(View.INVISIBLE);
                    }
                }
                mInputValueLabel.setText("");
                mOutputValueLabel.setText("");
                mUserInput.clear();
            }

            // Unused but declaration required for listener.
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            // Unused but declaration required for listener.
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /**
         * Performs a conversion of the current input to the base of the new position of the
         * to-seekbar.
         */
        mSeekBarTo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCurrentSeekbarToProgress = progress;
                mBaseToNumberLabel.setText(String.valueOf(mCurrentSeekbarToProgress
                        + SEEKBAR_PROGRESS_OFFSET));
                String output = "";
                for (Character i : mUserInput) {
                    output = output + i;
                }
                output = BaseConverter.baseConverter(output, mCurrentSeekbarFromProgress +
                        SEEKBAR_PROGRESS_OFFSET, mCurrentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (output.equals("0")) {
                    mOutputValueLabel.setText("");
                } else {
                    mOutputValueLabel.setText(output);
                }
            }

            // Unused but declaration required for listener.
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            // Unused but declaration required for listener.
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        /**
         * Copies the current output value to the clipboard if the view where it sits on is longpressed.
         */
        mOutputValueLabel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String outputText = mOutputValueLabel.getText().toString();
                if (!outputText.isEmpty()) {
                    mClipData = ClipData.newPlainText("text", outputText);
                    mClipboardManager.setPrimaryClip(mClipData);
                    Toast.makeText(getApplicationContext(), R.string.copied_to_clipboard, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        /**
         * Copies the current input value to the clipboard if the view where it sits on is longpressed.
         */
        mInputValueLabel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String inputText = mInputValueLabel.getText().toString();
                if (!inputText.isEmpty()) {
                    mClipData = ClipData.newPlainText("text", inputText);
                    mClipboardManager.setPrimaryClip(mClipData);
                    Toast.makeText(getApplicationContext(), R.string.copied_to_clipboard, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        /**
         * Removes the last digit from the current input, recalculates the conversion, and re-outputs.
         */
        mButtonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mUserInput.isEmpty()) {
                    mUserInput.remove(mUserInput.size() - 1);
                }
                String output = "";
                for (Character i : mUserInput) {
                    output = output + i;
                }
                mInputValueLabel.setText(output);
                output = BaseConverter.baseConverter(output, mCurrentSeekbarFromProgress +
                        SEEKBAR_PROGRESS_OFFSET, mCurrentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (output.equals("0")) {
                    mOutputValueLabel.setText("");
                } else {
                    mOutputValueLabel.setText(output);
                }
            }
        });

        /**
         * Removes all digits from current input and sets a blank output.
         */
        mButtonClr.setOnClickListener(new View.OnClickListener() {
            final int OFF_BY_ONE = 1;

            @Override
            public void onClick(View view) {
                while (!mUserInput.isEmpty()) {
                    mUserInput.remove(mUserInput.size() - OFF_BY_ONE);
                }
                String output = "";
                for (Character i : mUserInput) {
                    output = output + i;
                }
                mInputValueLabel.setText(output);
                mOutputValueLabel.setText("");
            }
        });

        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_0);
            }
        });

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_1);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_2);
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_3);
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_4);
            }
        });

        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_5);
            }
        });

        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_6);
            }
        });

        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_7);
            }
        });

        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_8);
            }
        });

        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_9);
            }
        });

        mButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_A);
            }
        });

        mButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_B);
            }
        });

        mButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_C);
            }
        });

        mButtonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_D);
            }
        });

        mButtonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_E);
            }
        });

        mButtonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_F);
            }
        });

    }

    /**
     * Saves the current input and output values as well as the internal representation of the
     * input for further processing.
     *
     * @param outState the bundle object that saves/restores data.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String input = "";
        for (Character i : mUserInput) {
            input = input + i;
        }
        outState.putString("input", input);
        outState.putString("inputLabelString", (String) mInputValueLabel.getText());
        outState.putString("outputLabelString", (String) mOutputValueLabel.getText());
    }

    /**
     * Restores the current input and output values as well as the internal representation of the
     * input for further processing.
     *
     * @param savedInstanceState the bundle object that saves/restores data.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String input = savedInstanceState.getString("input");
        for (int i = 0; i < input.length(); i++) {
            mUserInput.add(input.charAt(i));
        }
        mInputValueLabel.setText(savedInstanceState.getString("inputLabelString"));
        mOutputValueLabel.setText(savedInstanceState.getString("outputLabelString"));
    }

    /**
     * Sets the locale to a new language.
     *
     * @param lang the new language to set the app to.
     */
    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }

    /**
     * When the user selects an option in a DialogFragment without cancelling this method executes
     * passing back the result of the option the user selected. Since both changing the language or
     * theme requires the activity to be recreated to display the updates it doesn't matter what
     * the message is. As long as a message is received it means the cancel button wasn't clicked and
     * the user chose to either change the language or theme.
     *
     * @param message the result returned from opening a DialogFragment.
     */
    @Override
    public void onDialogMessage(String message) {
        this.recreate();
    }

    /**
     * Checks if the input is 0. If it is, there is nothing to process so the method returns.
     * If the input is greater than 0 then it checks if adding another digit would cause overflow.
     * If it doesn't, it adds that digit to the input, performs the conversion to the new base,
     * and sets it to the output.
     *
     * @param numberPressed The digit to be processed.
     */
    private void processNumberButtonPress(Character numberPressed) {
        if (numberPressed == CHAR_0 && mUserInput.isEmpty()) {
            return;
        }
        if (triggersOverflow()) {
            return;
        }
        mUserInput.add(numberPressed);
        String output = "";
        for (Character i : mUserInput) {
            output = output + i;
        }
        mInputValueLabel.setText(output);
        output = BaseConverter.baseConverter(output, mCurrentSeekbarFromProgress +
                SEEKBAR_PROGRESS_OFFSET, mCurrentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
        mOutputValueLabel.setText(output);
    }

    /**
     * Creates a hamburger-style menu and sets the custom font to each menu item.
     *
     * @param menu The menu to be created.
     * @return Status of the operation.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            applyFontToMenuItem(menuItem, mCustomFontSemiBold);
        }
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Starts an intent/opens a dialog window based on the menu item selected. Source code option
     * opens the developer's Github profile on a browser app. Theme and language options open a
     * dialog window to choose a new theme or language. Rate app option opens the app's url in the
     * Google Play store. Theme change feature only works on API levels higher than 19. If user is
     * running on API level 19 or lower an alert dialog shows an appropriate message.
     *
     * @param item The menu item being selected.
     * @return Status of the operation.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.menu_item_source_code):
                Intent sourceCodeIntent = new Intent(Intent.ACTION_VIEW);
                sourceCodeIntent.setData(Uri.parse(DEVELOPER_GITHUB_URL));
                Intent sourceCodeChooser = Intent.createChooser(sourceCodeIntent, getString(R.string.launch_browser));
                startActivity(sourceCodeChooser);
                break;
            case (R.id.menu_item_language):
                LanguageChooserDialog languageChooserDialog = new LanguageChooserDialog();
                languageChooserDialog.show(mFragmentManager, "dialog_language");
                break;
            case (R.id.menu_item_theme):
                if (SystemInfo.isRunningLollipopOrHigher()) {
                    ThemeChooserDialog themeChooserDialog = new ThemeChooserDialog();
                    themeChooserDialog.show(mFragmentManager, "dialog_theme");
                } else {
                    AlertDialog themeErrorBuilder = new AlertDialog.Builder(MainActivity.this)
                            .setMessage(R.string.theme_error_message).show();
                    TextView themeErrorTextView = (TextView) themeErrorBuilder
                            .findViewById(android.R.id.message);
                    themeErrorTextView.setTypeface(mCustomFontRegular);
                }
                break;
            case (R.id.menu_item_rate):
                Intent rateAppIntent = new Intent(Intent.ACTION_VIEW);
                rateAppIntent.setData(Uri.parse("market://details?id=" + getPackageName()));
                try {
                    startActivity(rateAppIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(this, R.string.google_play_error, Toast.LENGTH_LONG).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Sets a menu item to the custom font.
     *
     * @param menuItem The menu item to change to affect.
     * @param font     The font to be applied.
     */
    private void applyFontToMenuItem(MenuItem menuItem, Typeface font) {
        SpannableString mNewTitle = new SpannableString(menuItem.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        menuItem.setTitle(mNewTitle);
    }


    /**
     * Determines if overflow can occur from additional input based on the current from-base.
     *
     * @return if adding an additional digit would trigger overflow.
     */
    private boolean triggersOverflow() {

        int currentBaseFrom = mCurrentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET;
        Context context = getApplicationContext();
        CharSequence overflowToastMessage = getString(R.string.overflow_message);
        int toastDuration = Toast.LENGTH_SHORT;

        switch (currentBaseFrom) {
            case BASE_16:
                if (mUserInput.size() >= 14) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_15:
                if (mUserInput.size() >= 14) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_14:
                if (mUserInput.size() >= 15) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_13:
                if (mUserInput.size() >= 15) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_12:
                if (mUserInput.size() >= 16) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_11:
                if (mUserInput.size() >= 16) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_10:
                if (mUserInput.size() >= 17) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_9:
                if (mUserInput.size() >= 17) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_8:
                if (mUserInput.size() >= 21) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_7:
                if (mUserInput.size() >= 21) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_6:
                if (mUserInput.size() >= 23) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_5:
                if (mUserInput.size() >= 23) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_4:
                if (mUserInput.size() >= 31) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_3:
                if (mUserInput.size() >= 34) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_2:
                if (mUserInput.size() >= 51) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * Displays a toast notifying the user the number is getting too large and input cannot grow any further.
     * Cancels the current toast if there is one present to avoid a cluster of toasts queueing up.
     *
     * @param context  The current context.
     * @param message  The message to display.
     * @param duration The amount of time to display the message.
     */
    private void showOverflowMessage(Context context, CharSequence message, int duration) {
        if (mOverflowToast != null) {
            mOverflowToast.cancel();
        }
        mOverflowToast = Toast.makeText(context, message, duration);
        mOverflowToast.show();
    }

    /**
     * Loops through all views that contain text and sets the font to the custom font.
     */
    private void setCustomFont() {
        for (View view : mAllViewsArray) {
            TextView currentTextView = (TextView) view;
            currentTextView.setTypeface(mCustomFontSemiBold);
        }
    }
}
