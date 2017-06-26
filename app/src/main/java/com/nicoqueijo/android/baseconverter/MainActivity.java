package com.nicoqueijo.android.baseconverter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Android application. Converts numbers from one base to another supporting base 2 through 16.
 */
public class MainActivity extends AppCompatActivity {

    private final String EXO_2_SEMIBOLD_FONT_PATH = "fonts/Exo_2/Exo2-SemiBold.ttf";
    private final String EXO_2_REGULAR_FONT_PATH = "fonts/Exo_2/Exo2-Regular.ttf";
    private final String COPIED_TO_CLIPBOARD_MESSAGE = "Copied to clipboard!";

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

    private SeekBar mSeekBarFrom;
    private SeekBar mSeekBarTo;

    private TextView mFromLabel;
    private TextView mToLabel;
    private TextView mInputLabel;
    private TextView mOutputLabel;
    private TextView mBaseToLabel;
    private TextView mBaseFromLabel;

    private TextView mInputValueLabel;
    private TextView mOutputValueLabel;

    private TextView mNumberLabelFrom2;
    private TextView mNumberLabelFrom3;
    private TextView mNumberLabelFrom4;
    private TextView mNumberLabelFrom5;
    private TextView mNumberLabelFrom6;
    private TextView mNumberLabelFrom7;
    private TextView mNumberLabelFrom8;
    private TextView mNumberLabelFrom9;
    private TextView mNumberLabelFrom10;
    private TextView mNumberLabelFrom11;
    private TextView mNumberLabelFrom12;
    private TextView mNumberLabelFrom13;
    private TextView mNumberLabelFrom14;
    private TextView mNumberLabelFrom15;
    private TextView mNumberLabelFrom16;

    private TextView mNumberLabelTo2;
    private TextView mNumberLabelTo3;
    private TextView mNumberLabelTo4;
    private TextView mNumberLabelTo5;
    private TextView mNumberLabelTo6;
    private TextView mNumberLabelTo7;
    private TextView mNumberLabelTo8;
    private TextView mNumberLabelTo9;
    private TextView mNumberLabelTo10;
    private TextView mNumberLabelTo11;
    private TextView mNumberLabelTo12;
    private TextView mNumberLabelTo13;
    private TextView mNumberLabelTo14;
    private TextView mNumberLabelTo15;
    private TextView mNumberLabelTo16;

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

    private TextView[] mNumberLabelFromArray;
    private TextView[] mNumberLabelToArray;
    private Button[] mButtonsArray;
    private View[] mAllViewsArray;

    private ArrayList<Character> mUserInput = new ArrayList<>();
    private Typeface mCustomFontSemiBold;
    private Typeface mCustomFontRegular;

    private Toast mOverflowToast = null;
    private ClipboardManager mClipboardmanager;
    private ClipData mClipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeekBarFrom = (SeekBar) findViewById(R.id.seekbar_from_controller);
        mSeekBarTo = (SeekBar) findViewById(R.id.seekbar_to_controller);

        mFromLabel = (TextView) findViewById(R.id.from_label);
        mToLabel = (TextView) findViewById(R.id.to_label);
        mInputLabel = (TextView) findViewById(R.id.input_label);
        mOutputLabel = (TextView) findViewById(R.id.output_label);
        mBaseFromLabel = (TextView) findViewById(R.id.base_label_from);
        mBaseToLabel = (TextView) findViewById(R.id.base_label_to);

        mInputValueLabel = (TextView) findViewById(R.id.input_value);
        mOutputValueLabel = (TextView) findViewById(R.id.output_value);

        mNumberLabelFrom2 = (TextView) findViewById(R.id.from_base_label_2);
        mNumberLabelFrom3 = (TextView) findViewById(R.id.from_base_label_3);
        mNumberLabelFrom4 = (TextView) findViewById(R.id.from_base_label_4);
        mNumberLabelFrom5 = (TextView) findViewById(R.id.from_base_label_5);
        mNumberLabelFrom6 = (TextView) findViewById(R.id.from_base_label_6);
        mNumberLabelFrom7 = (TextView) findViewById(R.id.from_base_label_7);
        mNumberLabelFrom8 = (TextView) findViewById(R.id.from_base_label_8);
        mNumberLabelFrom9 = (TextView) findViewById(R.id.from_base_label_9);
        mNumberLabelFrom10 = (TextView) findViewById(R.id.from_base_label_10);
        mNumberLabelFrom11 = (TextView) findViewById(R.id.from_base_label_11);
        mNumberLabelFrom12 = (TextView) findViewById(R.id.from_base_label_12);
        mNumberLabelFrom13 = (TextView) findViewById(R.id.from_base_label_13);
        mNumberLabelFrom14 = (TextView) findViewById(R.id.from_base_label_14);
        mNumberLabelFrom15 = (TextView) findViewById(R.id.from_base_label_15);
        mNumberLabelFrom16 = (TextView) findViewById(R.id.from_base_label_16);

        mNumberLabelTo2 = (TextView) findViewById(R.id.to_base_label_2);
        mNumberLabelTo3 = (TextView) findViewById(R.id.to_base_label_3);
        mNumberLabelTo4 = (TextView) findViewById(R.id.to_base_label_4);
        mNumberLabelTo5 = (TextView) findViewById(R.id.to_base_label_5);
        mNumberLabelTo6 = (TextView) findViewById(R.id.to_base_label_6);
        mNumberLabelTo7 = (TextView) findViewById(R.id.to_base_label_7);
        mNumberLabelTo8 = (TextView) findViewById(R.id.to_base_label_8);
        mNumberLabelTo9 = (TextView) findViewById(R.id.to_base_label_9);
        mNumberLabelTo10 = (TextView) findViewById(R.id.to_base_label_10);
        mNumberLabelTo11 = (TextView) findViewById(R.id.to_base_label_11);
        mNumberLabelTo12 = (TextView) findViewById(R.id.to_base_label_12);
        mNumberLabelTo13 = (TextView) findViewById(R.id.to_base_label_13);
        mNumberLabelTo14 = (TextView) findViewById(R.id.to_base_label_14);
        mNumberLabelTo15 = (TextView) findViewById(R.id.to_base_label_15);
        mNumberLabelTo16 = (TextView) findViewById(R.id.to_base_label_16);

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

        mNumberLabelFromArray = new TextView[]{
                mNumberLabelFrom2, mNumberLabelFrom3, mNumberLabelFrom4,
                mNumberLabelFrom5, mNumberLabelFrom6, mNumberLabelFrom7,
                mNumberLabelFrom8, mNumberLabelFrom9, mNumberLabelFrom10,
                mNumberLabelFrom11, mNumberLabelFrom12, mNumberLabelFrom13,
                mNumberLabelFrom14, mNumberLabelFrom15, mNumberLabelFrom16
        };

        mNumberLabelToArray = new TextView[]{
                mNumberLabelTo2, mNumberLabelTo3, mNumberLabelTo4,
                mNumberLabelTo5, mNumberLabelTo6, mNumberLabelTo7,
                mNumberLabelTo8, mNumberLabelTo9, mNumberLabelTo10,
                mNumberLabelTo11, mNumberLabelTo12, mNumberLabelTo13,
                mNumberLabelTo14, mNumberLabelTo15, mNumberLabelTo16
        };

        mButtonsArray = new Button[]{
                mButton0, mButton1, mButton2, mButton3,
                mButton4, mButton5, mButton6, mButton7,
                mButton8, mButton9, mButtonA, mButtonB,
                mButtonC, mButtonD, mButtonE, mButtonF
        };

        mAllViewsArray = new View[]{
                mFromLabel, mToLabel, mInputLabel, mOutputLabel, mBaseToLabel, mBaseFromLabel,
                mInputValueLabel, mOutputValueLabel, mNumberLabelFrom2, mNumberLabelFrom3,
                mNumberLabelFrom4, mNumberLabelFrom5, mNumberLabelFrom6, mNumberLabelFrom7,
                mNumberLabelFrom8, mNumberLabelFrom9, mNumberLabelFrom10, mNumberLabelFrom11,
                mNumberLabelFrom12, mNumberLabelFrom13, mNumberLabelFrom14,
                mNumberLabelFrom15, mNumberLabelFrom16, mNumberLabelTo2, mNumberLabelTo3,
                mNumberLabelTo4, mNumberLabelTo5, mNumberLabelTo6, mNumberLabelTo7,
                mNumberLabelTo8, mNumberLabelTo9, mNumberLabelTo10, mNumberLabelTo11,
                mNumberLabelTo12, mNumberLabelTo13, mNumberLabelTo14, mNumberLabelTo15,
                mNumberLabelTo16, mButton0, mButton1, mButton2, mButton3, mButton4,
                mButton5, mButton6, mButton7, mButton8, mButton9, mButtonA, mButtonB,
                mButtonC, mButtonD, mButtonE, mButtonF, mButtonDel, mButtonClr
        };

        mCustomFontSemiBold = Typeface.createFromAsset(getAssets(), EXO_2_SEMIBOLD_FONT_PATH);
        mCustomFontRegular = Typeface.createFromAsset(getAssets(), EXO_2_REGULAR_FONT_PATH);
        mClipboardmanager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

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
                for (int i = 0; i < mNumberLabelFromArray.length; i++) {
                    if (i == progress) {
                        mNumberLabelFromArray[i].setVisibility(View.VISIBLE);
                    } else {
                        mNumberLabelFromArray[i].setVisibility(View.INVISIBLE);
                    }
                }
                for (int j = 0; j < mButtonsArray.length; j++) {
                    if (j <= progress + SEEKBAR_BUTTON_OFFSET) {
                        mButtonsArray[j].setVisibility(View.VISIBLE);
                    } else {
                        mButtonsArray[j].setVisibility(View.INVISIBLE);
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
                for (int i = 0; i < mNumberLabelToArray.length; i++) {
                    if (i == progress) {
                        mNumberLabelToArray[i].setVisibility(View.VISIBLE);
                    } else {
                        mNumberLabelToArray[i].setVisibility(View.INVISIBLE);
                    }
                }
                String output = "";
                for (Character i : mUserInput) {
                    output = output + i;
                }
                output = BaseConverterActivity.baseConverter(output, mCurrentSeekbarFromProgress +
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
                    mClipboardmanager.setPrimaryClip(mClipData);
                    Toast.makeText(getApplicationContext(), COPIED_TO_CLIPBOARD_MESSAGE, Toast.LENGTH_SHORT).show();
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
                    mClipboardmanager.setPrimaryClip(mClipData);
                    Toast.makeText(getApplicationContext(), COPIED_TO_CLIPBOARD_MESSAGE, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        /**
         * Listener for the DEL button. Removes the last digit from the current input, recalculates
         * the conversion, and re-outputs.
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
                output = BaseConverterActivity.baseConverter(output, mCurrentSeekbarFromProgress +
                        SEEKBAR_PROGRESS_OFFSET, mCurrentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (output.equals("0")) {
                    mOutputValueLabel.setText("");
                } else {
                    mOutputValueLabel.setText(output);
                }
            }
        });

        /**
         * Listener for the CLR button. Removes all digits from current input and sets a blank output.
         */
        mButtonClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                while (!mUserInput.isEmpty()) {
                    mUserInput.remove(mUserInput.size() - 1);
                }
                String output = "";
                for (Character i : mUserInput) {
                    output = output + i;
                }
                mInputValueLabel.setText(output);
                mOutputValueLabel.setText("");
            }
        });

        /**
         * Listener for button 0. Calls the processNumberButtonPress method passing the character
         * '0' as the argument.
         */
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_0);
            }
        });

        /**
         * Listener for button 1. Calls the processNumberButtonPress method passing the character
         * '1' as the argument.
         */
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_1);
            }
        });

        /**
         * Listener for button 2. Calls the processNumberButtonPress method passing the character
         * '2' as the argument.
         */
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_2);
            }
        });

        /**
         * Listener for button 3. Calls the processNumberButtonPress method passing the character
         * '3' as the argument.
         */
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_3);
            }
        });

        /**
         * Listener for button 4. Calls the processNumberButtonPress method passing the character
         * '4' as the argument.
         */
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_4);
            }
        });

        /**
         * Listener for button 5. Calls the processNumberButtonPress method passing the character
         * '5' as the argument.
         */
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_5);
            }
        });

        /**
         * Listener for button 6. Calls the processNumberButtonPress method passing the character
         * '6' as the argument.
         */
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_6);
            }
        });

        /**
         * Listener for button 7. Calls the processNumberButtonPress method passing the character
         * '7' as the argument.
         */
        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_7);
            }
        });

        /**
         * Listener for button 8. Calls the processNumberButtonPress method passing the character
         * '8' as the argument.
         */
        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_8);
            }
        });

        /**
         * Listener for button 9. Calls the processNumberButtonPress method passing the character
         * '9' as the argument.
         */
        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_9);
            }
        });

        /**
         * Listener for button A. Calls the processNumberButtonPress method passing the character
         * 'A' as the argument.
         */
        mButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_A);
            }
        });

        /**
         * Listener for button B. Calls the processNumberButtonPress method passing the character
         * 'B' as the argument.
         */
        mButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_B);
            }
        });

        /**
         * Listener for button C. Calls the processNumberButtonPress method passing the character
         * 'C' as the argument.
         */
        mButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_C);
            }
        });

        /**
         * Listener for button D. Calls the processNumberButtonPress method passing the character
         * 'D' as the argument.
         */
        mButtonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_D);
            }
        });

        /**
         * Listener for button E. Calls the processNumberButtonPress method passing the character
         * 'E' as the argument.
         */
        mButtonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_E);
            }
        });

        /**
         * Listener for button F. Calls the processNumberButtonPress method passing the character
         * 'F' as the argument.
         */
        mButtonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_F);
            }
        });

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
        output = BaseConverterActivity.baseConverter(output, mCurrentSeekbarFromProgress +
                SEEKBAR_PROGRESS_OFFSET, mCurrentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
        mOutputValueLabel.setText(output);
    }

    /**
     * Creates a hamburger-style menu and sets the font to each menu item.
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
     * Creates an alert dialog window with a custom message and displays it when a menu item is selected.
     *
     * @param item The menu item being selected.
     * @return Status of the operation.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        final String aboutMessage = "ABOUT\n\n" +
                "The source code for this project can be found at github.com/nicoqueijo";
        final String howToUseMessage = "HOW TO USE\n\n" +
                "Use the first slider to set the base of the number you want to convert.\n\n" +
                "Enter the number you want to convert using the buttons.\n\n" +
                "Use the second slider to convert the number to a new base.\n\n" +
                "You can also copy the input or output by longpressing it.";
        final String iconInfoMessage = "ICON INFO\n\n" +
                "Launcher icon for this app made by Freepik from www.flaticon.com is licensed by CC 3.0 BY";

        switch (item.getItemId()) {
            case (R.id.menu_about):
                AlertDialog aboutBuilder = new AlertDialog.Builder(MainActivity.this).setMessage(aboutMessage).show();
                TextView aboutTextView = (TextView) aboutBuilder.findViewById(android.R.id.message);
                aboutTextView.setTypeface(mCustomFontRegular);
                break;
            case (R.id.menu_how_to_use):
                AlertDialog howToUseBuilder = new AlertDialog.Builder(MainActivity.this).setMessage(howToUseMessage).show();
                TextView howToUseTextView = (TextView) howToUseBuilder.findViewById(android.R.id.message);
                howToUseTextView.setTypeface(mCustomFontRegular);
                break;
            case (R.id.menu_icon_info):
                AlertDialog iconInfoBuilder = new AlertDialog.Builder(MainActivity.this).setMessage(iconInfoMessage).show();
                TextView iconInfoTextView = (TextView) iconInfoBuilder.findViewById(android.R.id.message);
                iconInfoTextView.setTypeface(mCustomFontRegular);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Sets a menu item to a particular font.
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
        CharSequence overflowToastMessage = "Number too large!";
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
        for (int i = 0; i < mAllViewsArray.length; i++) {
            if (mAllViewsArray[i] instanceof TextView) {
                TextView currentTextView = (TextView) mAllViewsArray[i];
                currentTextView.setTypeface(mCustomFontSemiBold);
            } else if (mAllViewsArray[i] instanceof Button) {
                Button currentButton = (Button) mAllViewsArray[i];
                currentButton.setTypeface(mCustomFontSemiBold);
            }
        }
    }

}
