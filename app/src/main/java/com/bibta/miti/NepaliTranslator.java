package com.bibta.miti;

public class NepaliTranslator {
    public static char[] chars = new char[] {'०', '१', '२', '३', '४', '५', '६', '७', '८', '९'};
    /*public static String[] days = new String[] {
            ""
    }*/

    public static String getNepaliNumber(String english) {
        String nepali = "";
        for (int i=0; i<english.length(); ++i) {
            char c = english.charAt(i);
            if (c >= '0' && c <= '9')
                nepali += chars[Integer.parseInt(c+"")];
            else
                nepali += c;
        }
        return nepali;
    }
}
