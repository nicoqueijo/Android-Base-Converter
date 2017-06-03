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

    private int currentSeekbarFromProgress = SEEKBAR_FROM_START_LOCATION;
    private int currentSeekbarToProgress = SEEKBAR_TO_START_LOCATION;

    private SeekBar seekBarFrom;
    private SeekBar seekBarTo;

    private TextView fromLabel;
    private TextView toLabel;
    private TextView inputLabel;
    private TextView outputLabel;
    private TextView baseToLabel;
    private TextView baseFromLabel;

    private TextView inputValueLabel;
    private TextView outputValueLabel;

    private TextView numberLabelFrom2;
    private TextView numberLabelFrom3;
    private TextView numberLabelFrom4;
    private TextView numberLabelFrom5;
    private TextView numberLabelFrom6;
    private TextView numberLabelFrom7;
    private TextView numberLabelFrom8;
    private TextView numberLabelFrom9;
    private TextView numberLabelFrom10;
    private TextView numberLabelFrom11;
    private TextView numberLabelFrom12;
    private TextView numberLabelFrom13;
    private TextView numberLabelFrom14;
    private TextView numberLabelFrom15;
    private TextView numberLabelFrom16;

    private TextView numberLabelTo2;
    private TextView numberLabelTo3;
    private TextView numberLabelTo4;
    private TextView numberLabelTo5;
    private TextView numberLabelTo6;
    private TextView numberLabelTo7;
    private TextView numberLabelTo8;
    private TextView numberLabelTo9;
    private TextView numberLabelTo10;
    private TextView numberLabelTo11;
    private TextView numberLabelTo12;
    private TextView numberLabelTo13;
    private TextView numberLabelTo14;
    private TextView numberLabelTo15;
    private TextView numberLabelTo16;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private Button buttonE;
    private Button buttonF;
    private Button buttonDel;
    private Button buttonClr;

    private TextView[] numberLabelFromArray;
    private TextView[] numberLabelToArray;
    private Button[] buttonsArray;
    private View[] allViewsArray;

    private ArrayList<Character> userInput = new ArrayList<>();
    private Typeface customFontSemiBold;
    private Typeface customFontRegular;

    private Toast overflowToast = null;
    private ClipboardManager clipBoardManager;
    private ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarFrom = (SeekBar) findViewById(R.id.seekbar_from_controller);
        seekBarTo = (SeekBar) findViewById(R.id.seekbar_to_controller);

        fromLabel = (TextView) findViewById(R.id.from_label);
        toLabel = (TextView) findViewById(R.id.to_label);
        inputLabel = (TextView) findViewById(R.id.input_label);
        outputLabel = (TextView) findViewById(R.id.output_label);
        baseFromLabel = (TextView) findViewById(R.id.base_label_from);
        baseToLabel = (TextView) findViewById(R.id.base_label_to);

        inputValueLabel = (TextView) findViewById(R.id.input_value);
        outputValueLabel = (TextView) findViewById(R.id.output_value);

        numberLabelFrom2 = (TextView) findViewById(R.id.from_base_label_2);
        numberLabelFrom3 = (TextView) findViewById(R.id.from_base_label_3);
        numberLabelFrom4 = (TextView) findViewById(R.id.from_base_label_4);
        numberLabelFrom5 = (TextView) findViewById(R.id.from_base_label_5);
        numberLabelFrom6 = (TextView) findViewById(R.id.from_base_label_6);
        numberLabelFrom7 = (TextView) findViewById(R.id.from_base_label_7);
        numberLabelFrom8 = (TextView) findViewById(R.id.from_base_label_8);
        numberLabelFrom9 = (TextView) findViewById(R.id.from_base_label_9);
        numberLabelFrom10 = (TextView) findViewById(R.id.from_base_label_10);
        numberLabelFrom11 = (TextView) findViewById(R.id.from_base_label_11);
        numberLabelFrom12 = (TextView) findViewById(R.id.from_base_label_12);
        numberLabelFrom13 = (TextView) findViewById(R.id.from_base_label_13);
        numberLabelFrom14 = (TextView) findViewById(R.id.from_base_label_14);
        numberLabelFrom15 = (TextView) findViewById(R.id.from_base_label_15);
        numberLabelFrom16 = (TextView) findViewById(R.id.from_base_label_16);

        numberLabelTo2 = (TextView) findViewById(R.id.to_base_label_2);
        numberLabelTo3 = (TextView) findViewById(R.id.to_base_label_3);
        numberLabelTo4 = (TextView) findViewById(R.id.to_base_label_4);
        numberLabelTo5 = (TextView) findViewById(R.id.to_base_label_5);
        numberLabelTo6 = (TextView) findViewById(R.id.to_base_label_6);
        numberLabelTo7 = (TextView) findViewById(R.id.to_base_label_7);
        numberLabelTo8 = (TextView) findViewById(R.id.to_base_label_8);
        numberLabelTo9 = (TextView) findViewById(R.id.to_base_label_9);
        numberLabelTo10 = (TextView) findViewById(R.id.to_base_label_10);
        numberLabelTo11 = (TextView) findViewById(R.id.to_base_label_11);
        numberLabelTo12 = (TextView) findViewById(R.id.to_base_label_12);
        numberLabelTo13 = (TextView) findViewById(R.id.to_base_label_13);
        numberLabelTo14 = (TextView) findViewById(R.id.to_base_label_14);
        numberLabelTo15 = (TextView) findViewById(R.id.to_base_label_15);
        numberLabelTo16 = (TextView) findViewById(R.id.to_base_label_16);

        button0 = (Button) findViewById(R.id.button_0);
        button1 = (Button) findViewById(R.id.button_1);
        button2 = (Button) findViewById(R.id.button_2);
        button3 = (Button) findViewById(R.id.button_3);
        button4 = (Button) findViewById(R.id.button_4);
        button5 = (Button) findViewById(R.id.button_5);
        button6 = (Button) findViewById(R.id.button_6);
        button7 = (Button) findViewById(R.id.button_7);
        button8 = (Button) findViewById(R.id.button_8);
        button9 = (Button) findViewById(R.id.button_9);
        buttonA = (Button) findViewById(R.id.button_A);
        buttonB = (Button) findViewById(R.id.button_B);
        buttonC = (Button) findViewById(R.id.button_C);
        buttonD = (Button) findViewById(R.id.button_D);
        buttonE = (Button) findViewById(R.id.button_E);
        buttonF = (Button) findViewById(R.id.button_F);
        buttonDel = (Button) findViewById(R.id.button_del);
        buttonClr = (Button) findViewById(R.id.button_clr);

        numberLabelFromArray = new TextView[]{
                numberLabelFrom2, numberLabelFrom3, numberLabelFrom4,
                numberLabelFrom5, numberLabelFrom6, numberLabelFrom7,
                numberLabelFrom8, numberLabelFrom9, numberLabelFrom10,
                numberLabelFrom11, numberLabelFrom12, numberLabelFrom13,
                numberLabelFrom14, numberLabelFrom15, numberLabelFrom16
        };

        numberLabelToArray = new TextView[]{
                numberLabelTo2, numberLabelTo3, numberLabelTo4,
                numberLabelTo5, numberLabelTo6, numberLabelTo7,
                numberLabelTo8, numberLabelTo9, numberLabelTo10,
                numberLabelTo11, numberLabelTo12, numberLabelTo13,
                numberLabelTo14, numberLabelTo15, numberLabelTo16
        };

        buttonsArray = new Button[]{
                button0, button1, button2, button3,
                button4, button5, button6, button7,
                button8, button9, buttonA, buttonB,
                buttonC, buttonD, buttonE, buttonF
        };

        allViewsArray = new View[]{
                fromLabel, toLabel, inputLabel, outputLabel, baseToLabel, baseFromLabel,
                inputValueLabel, outputValueLabel, numberLabelFrom2, numberLabelFrom3,
                numberLabelFrom4, numberLabelFrom5, numberLabelFrom6, numberLabelFrom7,
                numberLabelFrom8, numberLabelFrom9, numberLabelFrom10, numberLabelFrom11,
                numberLabelFrom12, numberLabelFrom13, numberLabelFrom14,
                numberLabelFrom15, numberLabelFrom16, numberLabelTo2, numberLabelTo3,
                numberLabelTo4, numberLabelTo5, numberLabelTo6, numberLabelTo7,
                numberLabelTo8, numberLabelTo9, numberLabelTo10, numberLabelTo11,
                numberLabelTo12, numberLabelTo13, numberLabelTo14, numberLabelTo15,
                numberLabelTo16, button0, button1, button2, button3, button4,
                button5, button6, button7, button8, button9, buttonA, buttonB,
                buttonC, buttonD, buttonE, buttonF, buttonDel, buttonClr
        };

        customFontSemiBold = Typeface.createFromAsset(getAssets(), EXO_2_SEMIBOLD_FONT_PATH);
        customFontRegular = Typeface.createFromAsset(getAssets(), EXO_2_REGULAR_FONT_PATH);
        clipBoardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        setCustomFont();

        seekBarFrom.setProgress(SEEKBAR_FROM_START_LOCATION);
        seekBarTo.setProgress(SEEKBAR_TO_START_LOCATION);

        /**
         * Enables/disables buttons according to the position of the from-seekbar.
         * Also resets the current input if from-seekbar moves.
         */
        seekBarFrom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentSeekbarFromProgress = progress;
                for (int i = 0; i < numberLabelFromArray.length; i++) {
                    if (i == progress) {
                        numberLabelFromArray[i].setVisibility(View.VISIBLE);
                    } else {
                        numberLabelFromArray[i].setVisibility(View.INVISIBLE);
                    }
                }
                for (int j = 0; j < buttonsArray.length; j++) {
                    if (j <= progress + SEEKBAR_BUTTON_OFFSET) {
                        buttonsArray[j].setVisibility(View.VISIBLE);
                    } else {
                        buttonsArray[j].setVisibility(View.INVISIBLE);
                    }
                }
                inputValueLabel.setText("");
                outputValueLabel.setText("");
                userInput.clear();
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
        seekBarTo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentSeekbarToProgress = progress;
                for (int i = 0; i < numberLabelToArray.length; i++) {
                    if (i == progress) {
                        numberLabelToArray[i].setVisibility(View.VISIBLE);
                    } else {
                        numberLabelToArray[i].setVisibility(View.INVISIBLE);
                    }
                }
                String output = "";
                for (Character i : userInput) {
                    output = output + i;
                }
                output = BaseConverterActivity.baseConverter(output, currentSeekbarFromProgress +
                        SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (output.equals("0")) {
                    outputValueLabel.setText("");
                } else {
                    outputValueLabel.setText(output);
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
        outputValueLabel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String outputText = outputValueLabel.getText().toString();
                if (!outputText.isEmpty()) {
                    clipData = ClipData.newPlainText("text", outputText);
                    clipBoardManager.setPrimaryClip(clipData);
                    Toast.makeText(getApplicationContext(), COPIED_TO_CLIPBOARD_MESSAGE, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        /**
         * Copies the current input value to the clipboard if the view where it sits on is longpressed.
         */
        inputValueLabel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String inputText = inputValueLabel.getText().toString();
                if (!inputText.isEmpty()) {
                    clipData = ClipData.newPlainText("text", inputText);
                    clipBoardManager.setPrimaryClip(clipData);
                    Toast.makeText(getApplicationContext(), COPIED_TO_CLIPBOARD_MESSAGE, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        /**
         * Listener for the DEL button. Removes the last digit from the current input, recalculates
         * the conversion, and re-outputs.
         */
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!userInput.isEmpty()) {
                    userInput.remove(userInput.size() - 1);
                }
                String output = "";
                for (Character i : userInput) {
                    output = output + i;
                }
                inputValueLabel.setText(output);
                output = BaseConverterActivity.baseConverter(output, currentSeekbarFromProgress +
                        SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (output.equals("0")) {
                    outputValueLabel.setText("");
                } else {
                    outputValueLabel.setText(output);
                }
            }
        });

        /**
         * Listener for the CLR button. Removes all digits from current input and sets a blank output.
         */
        buttonClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                while (!userInput.isEmpty()) {
                    userInput.remove(userInput.size() - 1);
                }
                String output = "";
                for (Character i : userInput) {
                    output = output + i;
                }
                inputValueLabel.setText(output);
                outputValueLabel.setText("");
            }
        });

        /**
         * Listener for button 0. Calls the processNumberButtonPress method passing the character
         * '0' as the argument.
         */
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_0);
            }
        });

        /**
         * Listener for button 1. Calls the processNumberButtonPress method passing the character
         * '1' as the argument.
         */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_1);
            }
        });

        /**
         * Listener for button 2. Calls the processNumberButtonPress method passing the character
         * '2' as the argument.
         */
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_2);
            }
        });

        /**
         * Listener for button 3. Calls the processNumberButtonPress method passing the character
         * '3' as the argument.
         */
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_3);
            }
        });

        /**
         * Listener for button 4. Calls the processNumberButtonPress method passing the character
         * '4' as the argument.
         */
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_4);
            }
        });

        /**
         * Listener for button 5. Calls the processNumberButtonPress method passing the character
         * '5' as the argument.
         */
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_5);
            }
        });

        /**
         * Listener for button 6. Calls the processNumberButtonPress method passing the character
         * '6' as the argument.
         */
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_6);
            }
        });

        /**
         * Listener for button 7. Calls the processNumberButtonPress method passing the character
         * '7' as the argument.
         */
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_7);
            }
        });

        /**
         * Listener for button 8. Calls the processNumberButtonPress method passing the character
         * '8' as the argument.
         */
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_8);
            }
        });

        /**
         * Listener for button 9. Calls the processNumberButtonPress method passing the character
         * '9' as the argument.
         */
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_9);
            }
        });

        /**
         * Listener for button A. Calls the processNumberButtonPress method passing the character
         * 'A' as the argument.
         */
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_A);
            }
        });

        /**
         * Listener for button B. Calls the processNumberButtonPress method passing the character
         * 'B' as the argument.
         */
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_B);
            }
        });

        /**
         * Listener for button C. Calls the processNumberButtonPress method passing the character
         * 'C' as the argument.
         */
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_C);
            }
        });

        /**
         * Listener for button D. Calls the processNumberButtonPress method passing the character
         * 'D' as the argument.
         */
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_D);
            }
        });

        /**
         * Listener for button E. Calls the processNumberButtonPress method passing the character
         * 'E' as the argument.
         */
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_E);
            }
        });

        /**
         * Listener for button F. Calls the processNumberButtonPress method passing the character
         * 'F' as the argument.
         */
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNumberButtonPress(CHAR_F);
            }
        });

    }

    /**
     * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
     * to the input, performs the conversion to the new base, and sets it to the output.
     *
     * @param numberPressed The digit to be processed.
     */
    private void processNumberButtonPress(Character numberPressed) {
        if (triggersOverflow()) {
            return;
        }
        userInput.add(numberPressed);
        String output = "";
        for (Character i : userInput) {
            output = output + i;
        }
        inputValueLabel.setText(output);
        output = BaseConverterActivity.baseConverter(output, currentSeekbarFromProgress +
                SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
        if (output.equals("0")) {
            outputValueLabel.setText("");
        } else {
            outputValueLabel.setText(output);
        }
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
            applyFontToMenuItem(menuItem, customFontSemiBold);
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
                aboutTextView.setTypeface(customFontRegular);
                break;
            case (R.id.menu_how_to_use):
                AlertDialog howToUseBuilder = new AlertDialog.Builder(MainActivity.this).setMessage(howToUseMessage).show();
                TextView howToUseTextView = (TextView) howToUseBuilder.findViewById(android.R.id.message);
                howToUseTextView.setTypeface(customFontRegular);
                break;
            case (R.id.menu_icon_info):
                AlertDialog iconInfoBuilder = new AlertDialog.Builder(MainActivity.this).setMessage(iconInfoMessage).show();
                TextView iconInfoTextView = (TextView) iconInfoBuilder.findViewById(android.R.id.message);
                iconInfoTextView.setTypeface(customFontRegular);
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

        int currentBaseFrom = currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET;
        Context context = getApplicationContext();
        CharSequence overflowToastMessage = "Number too large!";
        int toastDuration = Toast.LENGTH_SHORT;

        switch (currentBaseFrom) {
            case BASE_16:
                if (userInput.size() >= 14) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_15:
                if (userInput.size() >= 14) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_14:
                if (userInput.size() >= 15) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_13:
                if (userInput.size() >= 15) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_12:
                if (userInput.size() >= 16) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_11:
                if (userInput.size() >= 16) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_10:
                if (userInput.size() >= 17) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_9:
                if (userInput.size() >= 17) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_8:
                if (userInput.size() >= 21) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_7:
                if (userInput.size() >= 21) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_6:
                if (userInput.size() >= 23) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_5:
                if (userInput.size() >= 23) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_4:
                if (userInput.size() >= 31) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_3:
                if (userInput.size() >= 34) {
                    showOverflowMessage(context, overflowToastMessage, toastDuration);
                    return true;
                }
                break;
            case BASE_2:
                if (userInput.size() >= 51) {
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
        if (overflowToast != null) {
            overflowToast.cancel();
        }
        overflowToast = Toast.makeText(context, message, duration);
        overflowToast.show();
    }

    /**
     * Loops through all views that contain text and sets the font to the custom font.
     */
    private void setCustomFont() {
        for (int i = 0; i < allViewsArray.length; i++) {
            if (allViewsArray[i] instanceof TextView) {
                TextView currentTextView = (TextView) allViewsArray[i];
                currentTextView.setTypeface(customFontSemiBold);
            } else if (allViewsArray[i] instanceof Button) {
                Button currentButton = (Button) allViewsArray[i];
                currentButton.setTypeface(customFontSemiBold);
            }
        }
    }

}
