package com.bibta.miti;

import java.util.Calendar;

// A simple date class

public class Date {
    public int year=0, month=0, day=0;

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
        return DateUtils.getNepaliDate(this);
    }

    Date convertToEnglish() { return DateUtils.getEnglishDate(this); }

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
