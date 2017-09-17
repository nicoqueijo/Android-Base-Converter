package com.nicoqueijo.android.baseconverter.fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.nicoqueijo.android.baseconverter.helpers.CornerRounder;
import com.nicoqueijo.android.baseconverter.activities.MainActivity;
import com.nicoqueijo.android.baseconverter.R;
import com.nicoqueijo.android.baseconverter.helpers.SystemInfo;
import com.nicoqueijo.android.baseconverter.interfaces.Communicator;

import java.util.Locale;

import java.util.Stack;

/**
 * Class for the dialog fragment window that lets the user change language.
 */
public class LanguageChooserDialog extends DialogFragment {

    public enum Language {
        en, // ENGLISH
        es, // SPANISH
        fr, // FRENCH
        de, // GERMAN
        it, // ITALIAN
        nl, // DUTCH
        pt, // PORTUGUESE
        pl, // POLISH
        ru, // RUSSIAN
        tr, // TURKISH
        zh, // CHINESE
        ja, // JAPANESE
        ko, // KOREAN
        ar, // ARABIC
        hi, // HINDI
        ms  // MALAY
    }

    private Communicator mCommunicator;
    private SharedPreferences mSharedPreferences;
    private Stack<RadioButton> mActiveRadioButton = new Stack<>();
    private View[] mAllViewsArray;

    private ImageView mUnitedKingdomFlag;
    private ImageView mSpainFlag;
    private ImageView mFranceFlag;
    private ImageView mGermanyFlag;
    private ImageView mItalyFlag;
    private ImageView mNetherlandsFlag;
    private ImageView mPortugalFlag;
    private ImageView mPolandFlag;
    private ImageView mRussiaFlag;
    private ImageView mTurkeyFlag;
    private ImageView mChinaFlag;
    private ImageView mJapanFlag;
    private ImageView mSouthKoreaFlag;
    private ImageView mSaudiArabiaFlag;
    private ImageView mIndiaFlag;
    private ImageView mMalaysiaFlag;

    private LinearLayout mEnglishOption;
    private LinearLayout mSpanishOption;
    private LinearLayout mFrenchOption;
    private LinearLayout mGermanOption;
    private LinearLayout mItalianOption;
    private LinearLayout mDutchOption;
    private LinearLayout mPortugueseOption;
    private LinearLayout mPolishOption;
    private LinearLayout mRussianOption;
    private LinearLayout mTurkishOption;
    private LinearLayout mChineseOption;
    private LinearLayout mJapaneseOption;
    private LinearLayout mKoreanOption;
    private LinearLayout mArabicOption;
    private LinearLayout mHindiOption;
    private LinearLayout mMalayOption;

    private RadioButton mEnglishRadioButton;
    private RadioButton mSpanishRadioButton;
    private RadioButton mFrenchRadioButton;
    private RadioButton mGermanRadioButton;
    private RadioButton mItalianRadioButton;
    private RadioButton mDutchRadioButton;
    private RadioButton mPortugueseRadioButton;
    private RadioButton mPolishRadioButton;
    private RadioButton mRussianRadioButton;
    private RadioButton mTurkishRadioButton;
    private RadioButton mChineseRadioButton;
    private RadioButton mJapaneseRadioButton;
    private RadioButton mKoreanRadioButton;
    private RadioButton mArabicRadioButton;
    private RadioButton mHindiRadioButton;
    private RadioButton mMalayRadioButton;

    private TextView mEnglishTextView;
    private TextView mSpanishTextView;
    private TextView mFrenchTextView;
    private TextView mGermanTextView;
    private TextView mItalianTextView;
    private TextView mDutchTextView;
    private TextView mPortugueseTextView;
    private TextView mPolishTextView;
    private TextView mRussianTextView;
    private TextView mTurkishTextView;
    private TextView mChineseTextView;
    private TextView mJapaneseTextView;
    private TextView mKoreanTextView;
    private TextView mArabicTextView;
    private TextView mHindiTextView;
    private TextView mMalayTextView;

    private TextView mLanguageTextView;
    private ScrollView mScrollView;
    private Button mCancelButton;

    /**
     * Empty constructor required for DialogFragment.
     */
    public LanguageChooserDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_languague_chooser, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSharedPreferences = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        removeTitleBar();

        mUnitedKingdomFlag = (ImageView) view.findViewById(R.id.flag_united_kingdom);
        mSpainFlag = (ImageView) view.findViewById(R.id.flag_spain);
        mFranceFlag = (ImageView) view.findViewById(R.id.flag_france);
        mGermanyFlag = (ImageView) view.findViewById(R.id.flag_germany);
        mItalyFlag = (ImageView) view.findViewById(R.id.flag_italy);
        mNetherlandsFlag = (ImageView) view.findViewById(R.id.flag_netherlands);
        mPortugalFlag = (ImageView) view.findViewById(R.id.flag_portugal);
        mPolandFlag = (ImageView) view.findViewById(R.id.flag_poland);
        mRussiaFlag = (ImageView) view.findViewById(R.id.flag_russia);
        mTurkeyFlag = (ImageView) view.findViewById(R.id.flag_turkey);
        mChinaFlag = (ImageView) view.findViewById(R.id.flag_china);
        mJapanFlag = (ImageView) view.findViewById(R.id.flag_japan);
        mSouthKoreaFlag = (ImageView) view.findViewById(R.id.flag_south_korea);
        mSaudiArabiaFlag = (ImageView) view.findViewById(R.id.flag_saudi_arabia);
        mIndiaFlag = (ImageView) view.findViewById(R.id.flag_india);
        mMalaysiaFlag = (ImageView) view.findViewById(R.id.flag_malaysia);

        mEnglishOption = (LinearLayout) view.findViewById(R.id.choice_english);
        mSpanishOption = (LinearLayout) view.findViewById(R.id.choice_spanish);
        mFrenchOption = (LinearLayout) view.findViewById(R.id.choice_french);
        mGermanOption = (LinearLayout) view.findViewById(R.id.choice_german);
        mItalianOption = (LinearLayout) view.findViewById(R.id.choice_italian);
        mDutchOption = (LinearLayout) view.findViewById(R.id.choice_dutch);
        mPortugueseOption = (LinearLayout) view.findViewById(R.id.choice_portuguese);
        mPolishOption = (LinearLayout) view.findViewById(R.id.choice_polish);
        mRussianOption = (LinearLayout) view.findViewById(R.id.choice_russian);
        mTurkishOption = (LinearLayout) view.findViewById(R.id.choice_turkish);
        mChineseOption = (LinearLayout) view.findViewById(R.id.choice_chinese);
        mJapaneseOption = (LinearLayout) view.findViewById(R.id.choice_japanese);
        mKoreanOption = (LinearLayout) view.findViewById(R.id.choice_korean);
        mArabicOption = (LinearLayout) view.findViewById(R.id.choice_arabic);
        mHindiOption = (LinearLayout) view.findViewById(R.id.choice_hindi);
        mMalayOption = (LinearLayout) view.findViewById(R.id.choice_malay);

        mEnglishRadioButton = (RadioButton) view.findViewById(R.id.radio_button_english);
        mSpanishRadioButton = (RadioButton) view.findViewById(R.id.radio_button_spanish);
        mFrenchRadioButton = (RadioButton) view.findViewById(R.id.radio_button_french);
        mGermanRadioButton = (RadioButton) view.findViewById(R.id.radio_button_german);
        mItalianRadioButton = (RadioButton) view.findViewById(R.id.radio_button_italian);
        mDutchRadioButton = (RadioButton) view.findViewById(R.id.radio_button_dutch);
        mPortugueseRadioButton = (RadioButton) view.findViewById(R.id.radio_button_portuguese);
        mPolishRadioButton = (RadioButton) view.findViewById(R.id.radio_button_polish);
        mRussianRadioButton = (RadioButton) view.findViewById(R.id.radio_button_russian);
        mTurkishRadioButton = (RadioButton) view.findViewById(R.id.radio_button_turkish);
        mChineseRadioButton = (RadioButton) view.findViewById(R.id.radio_button_chinese);
        mJapaneseRadioButton = (RadioButton) view.findViewById(R.id.radio_button_japanese);
        mKoreanRadioButton = (RadioButton) view.findViewById(R.id.radio_button_korean);
        mArabicRadioButton = (RadioButton) view.findViewById(R.id.radio_button_arabic);
        mHindiRadioButton = (RadioButton) view.findViewById(R.id.radio_button_hindi);
        mMalayRadioButton = (RadioButton) view.findViewById(R.id.radio_button_malay);

        mEnglishTextView = (TextView) view.findViewById(R.id.label_english);
        mSpanishTextView = (TextView) view.findViewById(R.id.label_spanish);
        mFrenchTextView = (TextView) view.findViewById(R.id.label_french);
        mGermanTextView = (TextView) view.findViewById(R.id.label_german);
        mItalianTextView = (TextView) view.findViewById(R.id.label_italian);
        mDutchTextView = (TextView) view.findViewById(R.id.label_dutch);
        mPortugueseTextView = (TextView) view.findViewById(R.id.label_portuguese);
        mPolishTextView = (TextView) view.findViewById(R.id.label_polish);
        mRussianTextView = (TextView) view.findViewById(R.id.label_russian);
        mTurkishTextView = (TextView) view.findViewById(R.id.label_turkish);
        mChineseTextView = (TextView) view.findViewById(R.id.label_chinese);
        mJapaneseTextView = (TextView) view.findViewById(R.id.label_japanese);
        mKoreanTextView = (TextView) view.findViewById(R.id.label_korean);
        mArabicTextView = (TextView) view.findViewById(R.id.label_arabic);
        mHindiTextView = (TextView) view.findViewById(R.id.label_hindi);
        mMalayTextView = (TextView) view.findViewById(R.id.label_malay);

        mLanguageTextView = (TextView) view.findViewById(R.id.label_language);
        mScrollView = (ScrollView) view.findViewById(R.id.scroll_view);
        mCancelButton = (Button) view.findViewById(R.id.button_cancel);

        mAllViewsArray = new View[]{
                mLanguageTextView, mCancelButton, mEnglishTextView, mSpanishTextView,
                mFrenchTextView, mGermanTextView, mItalianTextView, mDutchTextView,
                mPortugueseTextView, mPolishTextView, mRussianTextView, mTurkishTextView,
                mChineseTextView, mJapaneseTextView, mKoreanTextView, mArabicTextView,
                mHindiTextView, mMalayTextView
        };

        setCustomFont();
        disableRadioButtonsClickability();
        restoreSavedLanguage();
        restoreSavedScrollingPosition();
        roundFlagImageCorners();

        mEnglishOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mEnglishRadioButton, Language.en);
            }
        });

        mSpanishOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mSpanishRadioButton, Language.es);
            }
        });

        mFrenchOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mFrenchRadioButton, Language.fr);
            }
        });

        mGermanOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mGermanRadioButton, Language.de);
            }
        });

        mItalianOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mItalianRadioButton, Language.it);
            }
        });

        mDutchOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mDutchRadioButton, Language.nl);
            }
        });

        mPortugueseOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mPortugueseRadioButton, Language.pt);
            }
        });

        mPolishOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mPolishRadioButton, Language.pl);
            }
        });

        mRussianOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mRussianRadioButton, Language.ru);
            }
        });

        mTurkishOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mTurkishRadioButton, Language.tr);
            }
        });

        mChineseOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mChineseRadioButton, Language.zh);
            }
        });

        mJapaneseOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mJapaneseRadioButton, Language.ja);
            }
        });

        mKoreanOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mKoreanRadioButton, Language.ko);
            }
        });

        mArabicOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mArabicRadioButton, Language.ar);
            }
        });

        mHindiOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mHindiRadioButton, Language.hi);
            }
        });

        mMalayOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(mMalayRadioButton, Language.ms);
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
     * All the RadioButtons are grouped manually using a stack. Since only one radio button can be
     * pressed at a time, a stack is used to pop a button and push another when the user presses
     * buttons. When a button is pressed it pops the previous button (if any) and pushes the pressed
     * button. The language of the pressed button is saved to SharedPreferences and the locale is
     * changed to the new language. A message is sent back to the hosting activity to update the
     * layout using the strings of the new language.
     *
     * @param languageRadioButton the RadioButton pressed.
     * @param language            the language of the RadioButton pressed.
     */
    private void changeLanguage(RadioButton languageRadioButton, Language language) {
        if (!mActiveRadioButton.isEmpty()) {
            mActiveRadioButton.pop().setChecked(false);
        }
        languageRadioButton.setChecked(true);
        mActiveRadioButton.push(languageRadioButton);
        saveLanguage(language);
        setLocale(language.name());
        mCommunicator.onDialogMessage(language.name());
        saveScrollPositionAndDismiss();
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
     * Rounds the corners of all the flag image views by calling a static method in the
     * CornerRounder class.
     */
    private void roundFlagImageCorners() {
        CornerRounder.roundImageCorners(mUnitedKingdomFlag, mSpainFlag, mFranceFlag, mGermanyFlag,
                mItalyFlag, mNetherlandsFlag, mPortugalFlag, mPolandFlag, mRussiaFlag, mTurkeyFlag,
                mChinaFlag, mJapanFlag, mSouthKoreaFlag, mSaudiArabiaFlag, mIndiaFlag, mMalaysiaFlag);
    }

    /**
     * Dismisses the dialog when the user selects a language and saves the position of the scrollbar
     * in the process.
     */
    private void saveScrollPositionAndDismiss() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt("language_scroll_position", mScrollView.getScrollY());
        editor.commit();
        dismiss();
    }

    /**
     * Saves the language that the user selected to SharedPreferences.
     *
     * @param language the language that the user selected.
     */
    private void saveLanguage(Language language) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("language", language.name());
        editor.commit();
    }

    /**
     * Retrieves the language setting from the SharedPreferences file and sets that language to the
     * appropriate RadioButton. If this is the first time running the app SharedPreferences won't
     * have a language value and the default value will be the system language. If the system
     * language is not a supported language in this app it defaults to English.
     */
    private void restoreSavedLanguage() {
        String savedLanguage = mSharedPreferences.getString("language", SystemInfo.SYSTEM_LOCALE);
        if (savedLanguage.equals(Language.en.name())) {
            mEnglishRadioButton.setChecked(true);
            mActiveRadioButton.push(mEnglishRadioButton);
        } else if (savedLanguage.equals(Language.es.name())) {
            mSpanishRadioButton.setChecked(true);
            mActiveRadioButton.push(mSpanishRadioButton);
        } else if (savedLanguage.equals(Language.fr.name())) {
            mFrenchRadioButton.setChecked(true);
            mActiveRadioButton.push(mFrenchRadioButton);
        } else if (savedLanguage.equals(Language.de.name())) {
            mGermanRadioButton.setChecked(true);
            mActiveRadioButton.push(mGermanRadioButton);
        } else if (savedLanguage.equals(Language.it.name())) {
            mItalianRadioButton.setChecked(true);
            mActiveRadioButton.push(mItalianRadioButton);
        } else if (savedLanguage.equals(Language.nl.name())) {
            mDutchRadioButton.setChecked(true);
            mActiveRadioButton.push(mDutchRadioButton);
        } else if (savedLanguage.equals(Language.pt.name())) {
            mPortugueseRadioButton.setChecked(true);
            mActiveRadioButton.push(mPortugueseRadioButton);
        } else if (savedLanguage.equals(Language.pl.name())) {
            mPolishRadioButton.setChecked(true);
            mActiveRadioButton.push(mPolishRadioButton);
        } else if (savedLanguage.equals(Language.ru.name())) {
            mRussianRadioButton.setChecked(true);
            mActiveRadioButton.push(mRussianRadioButton);
        } else if (savedLanguage.equals(Language.tr.name())) {
            mTurkishRadioButton.setChecked(true);
            mActiveRadioButton.push(mTurkishRadioButton);
        } else if (savedLanguage.equals(Language.zh.name())) {
            mChineseRadioButton.setChecked(true);
            mActiveRadioButton.push(mChineseRadioButton);
        } else if (savedLanguage.equals(Language.ja.name())) {
            mJapaneseRadioButton.setChecked(true);
            mActiveRadioButton.push(mJapaneseRadioButton);
        } else if (savedLanguage.equals(Language.ko.name())) {
            mKoreanRadioButton.setChecked(true);
            mActiveRadioButton.push(mKoreanRadioButton);
        } else if (savedLanguage.equals(Language.ar.name())) {
            mArabicRadioButton.setChecked(true);
            mActiveRadioButton.push(mArabicRadioButton);
        } else if (savedLanguage.equals(Language.hi.name())) {
            mHindiRadioButton.setChecked(true);
            mActiveRadioButton.push(mHindiRadioButton);
        } else if (savedLanguage.equals(Language.ms.name())) {
            mMalayRadioButton.setChecked(true);
            mActiveRadioButton.push(mMalayRadioButton);
        } else {
            mEnglishRadioButton.setChecked(true);
            mActiveRadioButton.push(mEnglishRadioButton);
        }
    }

    /**
     * Retrieves the position of the the ScrollBar from the state of the last time a language was
     * selected and scrolls to that position. Since there is no horizontal ScrollBar, the x position
     * is 0.
     */
    private void restoreSavedScrollingPosition() {
        final int X_POSITION = 0;
        final int Y_POSITION = mSharedPreferences.getInt("language_scroll_position", 0);
        mScrollView.post(new Runnable() {
            public void run() {
                mScrollView.scrollTo(X_POSITION, Y_POSITION);
            }
        });
    }

    /**
     * Sets clickable of all RadioButtons to false because their clicks are handled by their parent
     * view.
     */
    private void disableRadioButtonsClickability() {
        mEnglishRadioButton.setClickable(false);
        mSpanishRadioButton.setClickable(false);
        mFrenchRadioButton.setClickable(false);
        mGermanRadioButton.setClickable(false);
        mItalianRadioButton.setClickable(false);
        mDutchRadioButton.setClickable(false);
        mPortugueseRadioButton.setClickable(false);
        mPolishRadioButton.setClickable(false);
        mRussianRadioButton.setClickable(false);
        mTurkishRadioButton.setClickable(false);
        mChineseRadioButton.setClickable(false);
        mJapaneseRadioButton.setClickable(false);
        mKoreanRadioButton.setClickable(false);
        mArabicRadioButton.setClickable(false);
        mHindiRadioButton.setClickable(false);
        mMalayRadioButton.setClickable(false);
    }

    /**
     * Overrides the class's onStart method so the window size could be adjusted at run-time.
     */
    @Override
    public void onStart() {
        super.onStart();
        adjustWindowSize();
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
     * Removes title bar from dialog fragment that is displayed on older API versions.
     */
    private void removeTitleBar() {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * Adjusts the dialog fragment's window size in accordance to the device resolution.
     * Sets the dialog fragment's window width to 92% of the device's screen width.
     * Sets the dialog fragment's window height to 80% of the device's screen height.
     */
    private void adjustWindowSize() {
        final double WIDTH_PERCENTAGE = 0.92;
        final double HEIGHT_PERCENTAGE = 0.80;
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        int newWidth = (int) (WIDTH_PERCENTAGE * (double) width);
        int newHeight = (int) (HEIGHT_PERCENTAGE * (double) height);
        getDialog().getWindow().setLayout(newWidth, newHeight);
    }

    /**
     * Determines the aspect ratio of the running device by dividing the height by the width.
     *
     * @return the aspect ratio of the running device
     */
    private double getAspectRatio() {
        double width = (double) getResources().getDisplayMetrics().widthPixels;
        double height = (double) getResources().getDisplayMetrics().heightPixels;
        return (height / width);
    }

    /**
     * Assuming the aspect ratio of a standard phone is 1.777 (the division of 16 by 9) this method
     * tries to determine if the aspect ratio of the running device is of that of a tablet.
     *
     * @return whether the aspect ratio on the running device resembles a tablet.
     */
    private boolean isRunningOnTablet() {
        final double MINIMUM_ASPECT_RATIO_OF_A_PHONE = 1.6;
        return getAspectRatio() < MINIMUM_ASPECT_RATIO_OF_A_PHONE;
    }

    /**
     * Loops through all language text views and sets the font to the custom font. Also sets the
     * dialog title view and button view to the bold custom font.
     */
    private void setCustomFont() {
        for (View view : mAllViewsArray) {
            TextView currentTextView = (TextView) view;
            currentTextView.setTypeface(MainActivity.mCustomFontRegular);
        }
        mCancelButton.setTypeface(MainActivity.mCustomFontSemiBold);
        mLanguageTextView.setTypeface(MainActivity.mCustomFontSemiBold);
    }
}
