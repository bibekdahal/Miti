package com.bibta.miti;

public class NepaliTranslator {
    public final static char[] digits = new char[] { '०', '१', '२', '३', '४', '५', '६', '७', '८', '९' };
    public final static String[] months = { "बैशाख", "जेष्ठ", "अषाढ", "श्रावण", "भाद्र", "असोज", "कात्तिक", "मंसिर", "पौष", "माघ", "फाल्गुन", "चैत्र" };
    public final static String[] days = { "आईतबार", "सोमबार", "मंगलबार", "बुधबार", "बिहीबार", "शुक्रबार", "शनिबार" };

    public static String getMonth(int month) {
        return months[month-1];
    }

    public static String getDay(int day) {
        return days[day];
    }

    public static String getShortDay(int day) {
        String longDay = getDay(day);
        return longDay.substring(0, longDay.indexOf("बार"));
    }

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
