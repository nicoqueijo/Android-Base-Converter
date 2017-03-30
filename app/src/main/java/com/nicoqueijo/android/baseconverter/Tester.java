package com.nicoqueijo.android.baseconverter;

import static com.nicoqueijo.android.baseconverter.R.string.base;

/**
 * Created by nicoqueijo on 30/03/2017.
 */

public class Tester {

    public static void main(String[] args) {
        int baseFrom = 3;
        int baseTo = 12;
        String num = "2012002";
        String answer = BaseConverterActivity.baseConverter(num, baseFrom, baseTo);
        System.out.println(answer);
    }

}
