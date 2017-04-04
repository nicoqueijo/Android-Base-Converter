// TODO: Change title bar font
// TODO: Change seekbar bar and thumb thickness
// TODO: Try to add base number labels inside the seekbar thumb
// TODO: Change colour/theme
// TODO: Add hamburger menu with app info, how to use instructions, icon launcher credit
// TODO: Refactor entire back-end. Apply code reusability using methods.
// TODO: Document everything
// TODO: Test on multiple devices
// TODO: Publish to playstore

package com.nicoqueijo.android.baseconverter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String EXO_2_FONT_PATH = "fonts/Exo_2/Exo2-SemiBold.ttf";
    private final String copiedToClipboardMessage = "Copied to clipboard!";

    private final int SEEKBAR_FROM_START_LOCATION = 8;
    private final int SEEKBAR_TO_START_LOCATION = 0;
    private final int SEEKBAR_BUTTON_OFFSET = 1;
    private final int SEEKBAR_PROGRESS_OFFSET = 2;

    private final int BASE_TWO = 2;
    private final int BASE_THREE = 3;
    private final int BASE_FOUR = 4;
    private final int BASE_FIVE = 5;
    private final int BASE_SIX = 6;
    private final int BASE_SEVEN = 7;
    private final int BASE_EIGHT = 8;
    private final int BASE_NINE = 9;
    private final int BASE_TEN = 10;
    private final int BASE_ELEVEN = 11;
    private final int BASE_TWELVE = 12;
    private final int BASE_THIRTEEN = 13;
    private final int BASE_FOURTEEN = 14;
    private final int BASE_FIFTEEN = 15;
    private final int BASE_SIXTEEN = 16;

    private final Character CHAR_ZERO = '0';
    private final Character CHAR_ONE = '1';
    private final Character CHAR_TWO = '2';
    private final Character CHAR_THREE = '3';
    private final Character CHAR_FOUR = '4';
    private final Character CHAR_FIVE = '5';
    private final Character CHAR_SIX = '6';
    private final Character CHAR_SEVEN = '7';
    private final Character CHAR_EIGHT = '8';
    private final Character CHAR_NINE = '9';
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

    private TextView numberLabelFromTwo;
    private TextView numberLabelFromThree;
    private TextView numberLabelFromFour;
    private TextView numberLabelFromFive;
    private TextView numberLabelFromSix;
    private TextView numberLabelFromSeven;
    private TextView numberLabelFromEight;
    private TextView numberLabelFromNine;
    private TextView numberLabelFromTen;
    private TextView numberLabelFromEleven;
    private TextView numberLabelFromTwelve;
    private TextView numberLabelFromThirteen;
    private TextView numberLabelFromFourteen;
    private TextView numberLabelFromFifteen;
    private TextView numberLabelFromSixteen;

    private TextView numberLabelToTwo;
    private TextView numberLabelToThree;
    private TextView numberLabelToFour;
    private TextView numberLabelToFive;
    private TextView numberLabelToSix;
    private TextView numberLabelToSeven;
    private TextView numberLabelToEight;
    private TextView numberLabelToNine;
    private TextView numberLabelToTen;
    private TextView numberLabelToEleven;
    private TextView numberLabelToTwelve;
    private TextView numberLabelToThirteen;
    private TextView numberLabelToFourteen;
    private TextView numberLabelToFifteen;
    private TextView numberLabelToSixteen;

    private Button buttonZero;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
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
    private Typeface customFont;
    private ClipboardManager clipBoardManager;
    private ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customFont = Typeface.createFromAsset(getAssets(), EXO_2_FONT_PATH);
        clipBoardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

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

        numberLabelFromTwo = (TextView) findViewById(R.id.from_base_label_two);
        numberLabelFromThree = (TextView) findViewById(R.id.from_base_label_three);
        numberLabelFromFour = (TextView) findViewById(R.id.from_base_label_four);
        numberLabelFromFive = (TextView) findViewById(R.id.from_base_label_five);
        numberLabelFromSix = (TextView) findViewById(R.id.from_base_label_six);
        numberLabelFromSeven = (TextView) findViewById(R.id.from_base_label_seven);
        numberLabelFromEight = (TextView) findViewById(R.id.from_base_label_eight);
        numberLabelFromNine = (TextView) findViewById(R.id.from_base_label_nine);
        numberLabelFromTen = (TextView) findViewById(R.id.from_base_label_ten);
        numberLabelFromEleven = (TextView) findViewById(R.id.from_base_label_eleven);
        numberLabelFromTwelve = (TextView) findViewById(R.id.from_base_label_twelve);
        numberLabelFromThirteen = (TextView) findViewById(R.id.from_base_label_thirteen);
        numberLabelFromFourteen = (TextView) findViewById(R.id.from_base_label_fourteen);
        numberLabelFromFifteen = (TextView) findViewById(R.id.from_base_label_fifteen);
        numberLabelFromSixteen = (TextView) findViewById(R.id.from_base_label_sixteen);

        numberLabelToTwo = (TextView) findViewById(R.id.to_base_label_two);
        numberLabelToThree = (TextView) findViewById(R.id.to_base_label_three);
        numberLabelToFour = (TextView) findViewById(R.id.to_base_label_four);
        numberLabelToFive = (TextView) findViewById(R.id.to_base_label_five);
        numberLabelToSix = (TextView) findViewById(R.id.to_base_label_six);
        numberLabelToSeven = (TextView) findViewById(R.id.to_base_label_seven);
        numberLabelToEight = (TextView) findViewById(R.id.to_base_label_eight);
        numberLabelToNine = (TextView) findViewById(R.id.to_base_label_nine);
        numberLabelToTen = (TextView) findViewById(R.id.to_base_label_ten);
        numberLabelToEleven = (TextView) findViewById(R.id.to_base_label_eleven);
        numberLabelToTwelve = (TextView) findViewById(R.id.to_base_label_twelve);
        numberLabelToThirteen = (TextView) findViewById(R.id.to_base_label_thirteen);
        numberLabelToFourteen = (TextView) findViewById(R.id.to_base_label_fourteen);
        numberLabelToFifteen = (TextView) findViewById(R.id.to_base_label_fifteen);
        numberLabelToSixteen = (TextView) findViewById(R.id.to_base_label_sixteen);

        buttonZero = (Button) findViewById(R.id.button_0);
        buttonOne = (Button) findViewById(R.id.button_1);
        buttonTwo = (Button) findViewById(R.id.button_2);
        buttonThree = (Button) findViewById(R.id.button_3);
        buttonFour = (Button) findViewById(R.id.button_4);
        buttonFive = (Button) findViewById(R.id.button_5);
        buttonSix = (Button) findViewById(R.id.button_6);
        buttonSeven = (Button) findViewById(R.id.button_7);
        buttonEight = (Button) findViewById(R.id.button_8);
        buttonNine = (Button) findViewById(R.id.button_9);
        buttonA = (Button) findViewById(R.id.button_A);
        buttonB = (Button) findViewById(R.id.button_B);
        buttonC = (Button) findViewById(R.id.button_C);
        buttonD = (Button) findViewById(R.id.button_D);
        buttonE = (Button) findViewById(R.id.button_E);
        buttonF = (Button) findViewById(R.id.button_F);
        buttonDel = (Button) findViewById(R.id.button_del);
        buttonClr = (Button) findViewById(R.id.button_clr);

        numberLabelFromArray = new TextView[]{
                numberLabelFromTwo, numberLabelFromThree, numberLabelFromFour,
                numberLabelFromFive, numberLabelFromSix, numberLabelFromSeven,
                numberLabelFromEight, numberLabelFromNine, numberLabelFromTen,
                numberLabelFromEleven, numberLabelFromTwelve, numberLabelFromThirteen,
                numberLabelFromFourteen, numberLabelFromFifteen, numberLabelFromSixteen
        };

        numberLabelToArray = new TextView[]{
                numberLabelToTwo, numberLabelToThree, numberLabelToFour,
                numberLabelToFive, numberLabelToSix, numberLabelToSeven,
                numberLabelToEight, numberLabelToNine, numberLabelToTen,
                numberLabelToEleven, numberLabelToTwelve, numberLabelToThirteen,
                numberLabelToFourteen, numberLabelToFifteen, numberLabelToSixteen
        };

        buttonsArray = new Button[]{
                buttonZero, buttonOne, buttonTwo, buttonThree,
                buttonFour, buttonFive, buttonSix, buttonSeven,
                buttonEight, buttonNine, buttonA, buttonB,
                buttonC, buttonD, buttonE, buttonF
        };

        allViewsArray = new View[]{
                fromLabel, toLabel, inputLabel, outputLabel, baseToLabel, baseFromLabel,
                inputValueLabel, outputValueLabel, numberLabelFromTwo, numberLabelFromThree,
                numberLabelFromFour, numberLabelFromFive, numberLabelFromSix, numberLabelFromSeven,
                numberLabelFromEight, numberLabelFromNine, numberLabelFromTen, numberLabelFromEleven,
                numberLabelFromTwelve, numberLabelFromThirteen, numberLabelFromFourteen,
                numberLabelFromFifteen, numberLabelFromSixteen, numberLabelToTwo, numberLabelToThree,
                numberLabelToFour, numberLabelToFive, numberLabelToSix, numberLabelToSeven,
                numberLabelToEight, numberLabelToNine, numberLabelToTen, numberLabelToEleven,
                numberLabelToTwelve, numberLabelToThirteen, numberLabelToFourteen, numberLabelToFifteen,
                numberLabelToSixteen, buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour,
                buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonA, buttonB,
                buttonC, buttonD, buttonE, buttonF, buttonDel, buttonClr
        };

        setCustomFont();

        seekBarFrom.setProgress(SEEKBAR_FROM_START_LOCATION);
        seekBarTo.setProgress(SEEKBAR_TO_START_LOCATION);

        /**
         * Enables/disables buttons according to the position of the first seekbar.
         * Also resets the current input if seekbar moves.
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

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /**
         * Performs a conversion of the current input to the base of the new position of the
         * second seekbar.
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

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /**
         * Copies the current output value to the clipboard if longpressed.
         */
        outputValueLabel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String outputText = outputValueLabel.getText().toString();
                if (!outputText.isEmpty()) {
                    clipData = ClipData.newPlainText("text", outputText);
                    clipBoardManager.setPrimaryClip(clipData);
                    Toast.makeText(getApplicationContext(), copiedToClipboardMessage, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        /**
         * Copies the current input value to the clipboard if longpressed.
         */
        inputValueLabel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String inputText = inputValueLabel.getText().toString();
                if (!inputText.isEmpty()) {
                    clipData = ClipData.newPlainText("text", inputText);
                    clipBoardManager.setPrimaryClip(clipData);
                    Toast.makeText(getApplicationContext(), copiedToClipboardMessage, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        /**
         * Removes the last digit from the current input and recalculates the conversion.
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
         * Removes all digits from current input and sets a blank output.
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit to
         * the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_ZERO);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_ONE);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_TWO);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_THREE);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_FOUR);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_FIVE);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_SIX);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_SEVEN);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_EIGHT);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_NINE);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_A);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_B);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_C);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_D);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_E);
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
         * Checks if adding another digit would cause overflow. If it doesn't, it adds that digit
         * to the input, performs the conversion to the new base, and sets it to the output.
         */
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (triggersOverflow()) {
                    return;
                }
                userInput.add(CHAR_F);
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

    }

    /**
     * Determines if overflow can occur from additional input based on the current working base.
     *
     * @return if adding an additional digit would trigger overflow.
     */
    private boolean triggersOverflow() {

        int currentBaseFrom = currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET;
        Context context = getApplicationContext();
        CharSequence text = "Number too large!";
        int duration = Toast.LENGTH_SHORT;
        Toast overflowToast = Toast.makeText(context, text, duration);

        switch (currentBaseFrom) {
            case BASE_SIXTEEN:
                if (userInput.size() >= 14) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_FIFTEEN:
                if (userInput.size() >= 14) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_FOURTEEN:
                if (userInput.size() >= 15) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_THIRTEEN:
                if (userInput.size() >= 15) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_TWELVE:
                if (userInput.size() >= 16) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_ELEVEN:
                if (userInput.size() >= 16) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_TEN:
                if (userInput.size() >= 17) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_NINE:
                if (userInput.size() >= 17) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_EIGHT:
                if (userInput.size() >= 21) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_SEVEN:
                if (userInput.size() >= 21) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_SIX:
                if (userInput.size() >= 23) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_FIVE:
                if (userInput.size() >= 23) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_FOUR:
                if (userInput.size() >= 31) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_THREE:
                if (userInput.size() >= 34) {
                    overflowToast.show();
                    return true;
                }
                break;
            case BASE_TWO:
                if (userInput.size() >= 51) {
                    overflowToast.show();
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * Loops through all views that contain text and sets the font to the custom font.
     */
    private void setCustomFont() {
        for (int i = 0; i < allViewsArray.length; i++) {
            if (allViewsArray[i] instanceof TextView) {
                TextView currentTextView = (TextView) allViewsArray[i];
                currentTextView.setTypeface(customFont);
            } else if (allViewsArray[i] instanceof Button) {
                Button currentButton = (Button) allViewsArray[i];
                currentButton.setTypeface(customFont);
            }
        }
    }

}
