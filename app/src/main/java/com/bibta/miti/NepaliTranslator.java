package com.bibta.miti;

/**
 * Nepali Translation Class to help translate to unicode devanagiri.
 */
public class NepaliTranslator {

    /// Nepali digits in devanagiri/unicode
    public final static char[] digits = new char[] {
            '०', '१', '२', '३', '४', '५', '६', '७','८', '९'
    };

    /// Nepali months in devanagiri/unicode
    public final static String[] months = {
            "बैशाख", "जेष्ठ", "अषाढ", "श्रावण", "भाद्र", "असोज", "कात्तिक", "मंसिर", "पौष", "माघ", "फाल्गुन", "चैत्र"
    };

    /// Nepali days in devanagiri/unicode
    public final static String[] days = {
            "आईतबार", "सोमबार", "मंगलबार", "बुधबार", "बिहीबार", "शुक्रबार", "शनिबार"
    };

    /**
     * Get nepali month in devanagiri/unicode.
     * @param month Month in the range [1, 12].
     * @return Nepali month in devanagiri/unicode.
     */
    public static String getMonth(int month) {
        return months[month-1];
    }

    /**
     * \Get nepali day as complete name in devanagiri/unicode.
     * @param day Day in range [0, 6].
     * @return Nepali day in devanagiri/unicode.
     */
    public static String getDay(int day) {
        return days[day];
    }

    /**
     * Get nepali day as short name (without बार at the end).
     * @param day Day in range[0, 6].
     * @return Short nepali day in devanagiri/unicode.
     */
    public static String getShortDay(int day) {
        String longDay = getDay(day);
        return longDay.substring(0, longDay.indexOf("बार"));
    }

    /**
     * Convert number to devanagiri/unicode.
     * @param english English number to convert.
     * @return Corresponding nepali number in devanagiri/unicode.
     */
    public static String getNumber(String english) {
        String nepali = "";
        for (int i=0; i<english.length(); ++i) {
            char c = english.charAt(i);
            if (c >= '0' && c <= '9')
                nepali += digits[Integer.parseInt(c+"")];
            else
                nepali += c;
        }
        return nepali;
    }
}
