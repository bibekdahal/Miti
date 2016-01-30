package com.bibta.miti;

import java.util.Calendar;

public class NepaliDate {
    public final static int startNepaliYear = 2000;
    public final static Date startEnglishDate = new Date(1943, 4, 14);

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

    public static int getNumDays(int year, int month) {
        return data[year-startNepaliYear][month-1];
    }

    public static class Date {
        public int year=0, month=0, day=0;
        public Date() {}

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public Date(Calendar calendar) {
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH) + 1;
            day = calendar.get(Calendar.DAY_OF_MONTH);
        }

        Calendar getCalendar() {
            Calendar c = Calendar.getInstance();
            c.clear();
            c.set(year, month - 1, day);
            return c;

        }

        Date convertToNepali() {
            return getDate(this);
        }

        Date convertToEnglish() { return getEnglishDate(this); }

        int getDaysTill(Date newDate) {
            return (int)((newDate.getCalendar().getTimeInMillis()
                    - getCalendar().getTimeInMillis())
                    / (24*60*60*1000))+1;
        }

        @Override
        public String toString() {
            return year+"/"+month+"/"+day;
        }
    }

    public static int getNumYears() {
        return data.length;
    }

    public static Date getDate(Date engDate) {
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
