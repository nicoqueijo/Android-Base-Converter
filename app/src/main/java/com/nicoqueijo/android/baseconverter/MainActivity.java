// TODO
// Switch int type in conversion to something much bigger (Big Integer? long?)
// TODO
// Handle overflow exceptions.
// TODO
// Make all container layouts symmetrical
// TODO
// Change colour/theme
// TODO
// Change fonts
// TODO
// Find and change app icon/logo
// TODO
// Document everything
// TODO
// Test on multiple devices and publish to playstore

package com.nicoqueijo.android.baseconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int SEEKBAR_FROM_START_LOCATION = 8;
    private final int SEEKBAR_TO_START_LOCATION = 0;
    private final int SEEKBAR_BUTTON_OFFSET = 1;
    private final int SEEKBAR_PROGRESS_OFFSET = 2;
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

    private TextView inputValue;
    private TextView outputValue;

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

    private ArrayList<Character> userInput = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarFrom = (SeekBar) findViewById(R.id.seekbar_from_controller);
        seekBarTo = (SeekBar) findViewById(R.id.seekbar_to_controller);

        inputValue = (TextView) findViewById(R.id.input_value);
        outputValue = (TextView) findViewById(R.id.output_value);

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

        seekBarFrom.setProgress(SEEKBAR_FROM_START_LOCATION);
        seekBarTo.setProgress(SEEKBAR_TO_START_LOCATION);

        final TextView[] numberLabelFromArray = new TextView[]{
                numberLabelFromTwo, numberLabelFromThree, numberLabelFromFour,
                numberLabelFromFive, numberLabelFromSix, numberLabelFromSeven,
                numberLabelFromEight, numberLabelFromNine, numberLabelFromTen,
                numberLabelFromEleven, numberLabelFromTwelve, numberLabelFromThirteen,
                numberLabelFromFourteen, numberLabelFromFifteen, numberLabelFromSixteen
        };

        final TextView[] numberLabelToArray = new TextView[]{
                numberLabelToTwo, numberLabelToThree, numberLabelToFour,
                numberLabelToFive, numberLabelToSix, numberLabelToSeven,
                numberLabelToEight, numberLabelToNine, numberLabelToTen,
                numberLabelToEleven, numberLabelToTwelve, numberLabelToThirteen,
                numberLabelToFourteen, numberLabelToFifteen, numberLabelToSixteen
        };

        final Button[] buttonsArray = new Button[]{
                buttonZero, buttonOne, buttonTwo, buttonThree,
                buttonFour, buttonFive, buttonSix, buttonSeven,
                buttonEight, buttonNine, buttonA, buttonB,
                buttonC, buttonD, buttonE, buttonF
        };

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
                inputValue.setText("");
                outputValue.setText("");
                userInput.clear();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!userInput.isEmpty()) {
                    userInput.remove(userInput.size() - 1);
                }
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                while (!userInput.isEmpty()) {
                    userInput.remove(userInput.size() - 1);
                }
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                outputValue.setText("");
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_ZERO);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }

            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_ONE);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_TWO);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_THREE);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_FOUR);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_FIVE);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_SIX);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_SEVEN);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_EIGHT);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_NINE);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_A);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_B);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_C);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_D);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_E);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.add(CHAR_F);
                String temp = "";
                for (Character i : userInput) {
                    temp = temp + i;
                }
                inputValue.setText(temp);
                temp = BaseConverterActivity.baseConverter(temp, currentSeekbarFromProgress + SEEKBAR_PROGRESS_OFFSET, currentSeekbarToProgress + SEEKBAR_PROGRESS_OFFSET);
                if (temp.equals("0")) {
                    outputValue.setText("");
                } else {
                    outputValue.setText(temp);
                }
            }
        });

    }

}
