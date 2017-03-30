package com.nicoqueijo.android.baseconverter;


public class BaseConverterActivity {

    private final static int OFFSET_OF_ONE = 1;
    private final static String HEX_TABLE = "0123456789ABCDEF";

    public static String baseConverter(String inputValue, int baseFrom, int baseTo) {
        String result = "";
        result = anythingToBaseTen(inputValue, baseFrom);
        result = baseTenToAnything(result, baseTo);
        return result;
    }


    public static String anythingToBaseTen(String subject, int baseFrom) {
        int result = 0;
        int subjectLength = subject.length();
        int exponent;

        for (int i = 0; i < subjectLength; i++) {
            char ch = subject.charAt(i);
            exponent = subjectLength - i - OFFSET_OF_ONE;
            result += (int) Math.pow(baseFrom, exponent) * HEX_TABLE.indexOf(ch);
        }

        return result + "";
    }

    public static String baseTenToAnything(String subject, int baseTo) {
        int valueAsNum = Integer.parseInt(subject);

        int quotient = valueAsNum;
        int remainder;
        String result = "";

        do {
            remainder = quotient % baseTo;
            result = HEX_TABLE.charAt(remainder) + result;
            quotient /= baseTo;
        } while (quotient != 0);

        return result;
    }

}
