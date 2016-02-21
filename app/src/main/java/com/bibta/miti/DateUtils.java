package com.bibta.miti;

import java.util.Calendar;

/**
 * Nepali date conversion utilities and database.
 */
public class DateUtils {
    /// Starting Nepali year that this database starts storing date from.
    public final static int startNepaliYear = 2000;
    /// Starting English year that this database starts storing date from.
    public final static Date startEnglishDate = new Date(1943, 4, 14);

    /**
     * Date Database useful for converting from/to Nepali/English dates.
     *
     * Basically, this is an array of arrays. Each sub-array represents a year.
     * Each year contains number of days in each month as array of integers.
     */
    public final static int[][] data = new int[][] {
        new int[] {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
        new int[] {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
        new int[] {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {30, 32, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
        new int[] {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {30, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31},
        new int[] {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31},
        new int[] {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30},
        new int[] {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30},
        new int[] {31, 31, 32, 32, 31, 30, 30, 30, 29, 30, 30, 30},
        new int[] {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30},
        new int[] {31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30},
        new int[] {31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30},
        new int[] {31, 32, 31, 32, 30, 31, 30, 30, 29, 30, 30, 30},
        new int[] {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30},
        new int[] {31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30},
        new int[] {30, 31, 32, 32, 30, 31, 30, 30, 29, 30, 30, 30},
        new int[] {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30},
        new int[] {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30},
    };

    /**
     * Get {@return number of days} in given {@param year} and {@param month}.
     */
    public static int getNumDays(int year, int month) {
        return data[year-startNepaliYear][month-1];
    }

    /**
     * Get {@return number of years} that this database stores.
     */
    public static int getNumYears() {
        return data.length;
    }

    /**
     * Convert English date to Nepali date.
     * @param engDate English date to convert from.
     * @return Corresponding Nepali date.
     */
    public static Date getNepaliDate(Date engDate) {
        int days = startEnglishDate.getDaysTill(engDate) + 1;

        for (int i=0; i<getNumYears(); ++i) {
            for (int j=0; j<12; ++j) {
                if (days > data[i][j])
                    days -= data[i][j];
                else
                    return new Date(i+startNepaliYear, j+1, days);
            }
        }
        return null;
    }

    /**
     * Convert Nepali date to English date.
     * @param nepDate Nepali date to convert from.
     * @return Corresponding English date.
     */
    public static Date getEnglishDate(Date nepDate) {
        int days = 0;
        int year = nepDate.year - startNepaliYear;

        for (int i=0; i<=year; ++i) {
            for (int j=0; j<12; ++j) {
                if (i == year && j == nepDate.month-1) {
                    days += nepDate.day - 1;

                    Calendar c = startEnglishDate.getCalendar();
                    c.add(Calendar.DATE, days);
                    return new Date(c);
                }
                else
                    days += data[i][j];
            }
        }
        return null;
    }
}
