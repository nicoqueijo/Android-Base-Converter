package com.nicoqueijo.android.baseconverter;

import com.nicoqueijo.android.baseconverter.algorithms.BaseConverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the accuracy of the main algorithm of the application which converts a number
 * from one base to another. There are thirty test cases conducted with random numbers of various
 * lengths from one random base to another random base assuring the random number is in the form
 * of the random base, of course.
 */
public class BaseConverterAlgorithmTest {

    @Test
    public void testBaseConversion_2To9() throws Exception {
        String expected = "51";
        String actual = BaseConverter.baseConverter("101110", 2, 9);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_3To15() throws Exception {
        String expected = "22E";
        String actual = BaseConverter.baseConverter("200022", 3, 15);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_4To6() throws Exception {
        String expected = "22530";
        String actual = BaseConverter.baseConverter("302112", 4, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_5To2() throws Exception {
        String expected = "10001111110100";
        String actual = BaseConverter.baseConverter("243304", 5, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_6To12() throws Exception {
        String expected = "22A08";
        String actual = BaseConverter.baseConverter("554412", 6, 12);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_7To13() throws Exception {
        String expected = "2013B";
        String actual = BaseConverter.baseConverter("326114", 7, 13);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_8To16() throws Exception {
        String expected = "19B3A";
        String actual = BaseConverter.baseConverter("315472", 8, 16);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_9To14() throws Exception {
        String expected = "9C907";
        String actual = BaseConverter.baseConverter("638774", 9, 14);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_10To4() throws Exception {
        String expected = "3301010300";
        String actual = BaseConverter.baseConverter("987440", 10, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_11To5() throws Exception {
        String expected = "201002100";
        String actual = BaseConverter.baseConverter("4A4A02", 11, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_12To8() throws Exception {
        String expected = "11530175";
        String actual = BaseConverter.baseConverter("A233B9", 12, 8);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_13To11() throws Exception {
        String expected = "1766739";
        String actual = BaseConverter.baseConverter("80B68A", 13, 11);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_14To7() throws Exception {
        String expected = "12553566";
        String actual = BaseConverter.baseConverter("2214DD", 14, 7);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_15To10() throws Exception {
        String expected = "7063816";
        String actual = BaseConverter.baseConverter("947EB1", 15, 10);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_16To3() throws Exception {
        String expected = "101212222100010";
        String actual = BaseConverter.baseConverter("584ACF", 16, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_2To10() throws Exception {
        String expected = "1641935205874954";
        String actual = BaseConverter.baseConverter("101110101010101010011010100101100001011110100001010", 2, 10);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_3To14() throws Exception {
        String expected = "140CCABB46173C8";
        String actual = BaseConverter.baseConverter("2120122101201220110122202121002222", 3, 14);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_4To9() throws Exception {
        String expected = "27873528672806007171";
        String actual = BaseConverter.baseConverter("3120131302103131022233120231333", 4, 9);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_5To3() throws Exception {
        String expected = "1201102120200202112121212202002002";
        String actual = BaseConverter.baseConverter("40010424133334101432314", 5, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_6To15() throws Exception {
        String expected = "19C67985B6254694";
        String actual = BaseConverter.baseConverter("53012542501245233553004", 6, 15);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_7To2() throws Exception {
        String expected = "100111011011000011011111110011100011001101011011101010";
        String actual = BaseConverter.baseConverter("6546210340162543132", 7, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_8To12() throws Exception {
        String expected = "3B349B4123729A69A6";
        String actual = BaseConverter.baseConverter("745216025765777562016", 8, 12);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_9To13() throws Exception {
        String expected = "4088C4C5591624B";
        String actual = BaseConverter.baseConverter("85426100751063227", 9, 13);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_10To16() throws Exception {
        String expected = "1533C31B714EF34";
        String actual = BaseConverter.baseConverter("95486201327578932", 10, 16);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_11To6() throws Exception {
        String expected = "1530302344044220314053";
        String actual = BaseConverter.baseConverter("A09473A168A52710", 11, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_12To4() throws Exception {
        String expected = "21320000011212012233232201213";
        String actual = BaseConverter.baseConverter("B667A0398A5412B3", 12, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_13To5() throws Exception {
        String expected = "402330003213304422243330";
        String actual = BaseConverter.baseConverter("C5947A50BB96523", 13, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_14To8() throws Exception {
        String expected = "10103240733057030734";
        String actual = BaseConverter.baseConverter("D27A960C6476A84", 14, 8);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_15To11() throws Exception {
        String expected = "6772768329151007";
        String actual = BaseConverter.baseConverter("E58C6D9430A711", 15, 11);
        assertEquals(expected, actual);
    }

    @Test
    public void testBaseConversion_16To7() throws Exception {
        String expected = "56604213035022361132";
        String actual = BaseConverter.baseConverter("F23A76E90CA46B", 16, 7);
        assertEquals(expected, actual);
    }
}
