package com.nicoqueijo.android.baseconverter.algorithms;

/**
 * Provides static methods to convert a number from one base to another supporting bases 2 through 16.
 */
public class BaseConverter {

    private final static int OFFSET_OF_ONE = 1;
    private final static String HEX_TABLE = "0123456789ABCDEF";

    /**
     * Encapsulates two conversion methods into one to simplify the conversion method call.
     *
     * @param inputValue The number to be converted.
     * @param baseFrom   The base of the number to be converted.
     * @param baseTo     The desired base of the number after the conversion.
     * @return The resulting number after the conversion.
     */
    public static String baseConverter(String inputValue, int baseFrom, int baseTo) {
        String result = "";
        result = anythingToBaseTen(inputValue, baseFrom);
        result = baseTenToAnything(result, baseTo);
        return result;
    }

    /**
     * Takes a number in any base and converts it into base 10.
     *
     * @param subject  The number to be converted to base 10.
     * @param baseFrom The base of the original number to be converted.
     * @return The number after the conversion (in base 10).
     */
    private static String anythingToBaseTen(String subject, int baseFrom) {
        long result = 0L;
        int subjectLength = subject.length();
        int exponent;

        for (int i = 0; i < subjectLength; i++) {
            char ch = subject.charAt(i);
            exponent = subjectLength - i - OFFSET_OF_ONE;
            result += (long) Math.pow(baseFrom, exponent) * HEX_TABLE.indexOf(ch);
        }
        return result + "";
    }

    /**
     * Takes a number in base 10 and converts it into any base.
     *
     * @param subject The number to be converted.
     * @param baseTo  The base to be converted into.
     * @return The number after the conversion  in the desired base.
     */
    private static String baseTenToAnything(String subject, int baseTo) {
        long valueAsNum = Long.parseLong(subject);
        long quotient = valueAsNum;
        long remainder;
        String result = "";

        do {
            remainder = quotient % baseTo;
            result = HEX_TABLE.charAt((int) remainder) + result;
            quotient /= baseTo;
        } while (quotient != 0);
        return result;
    }

}
