package com.bibta.miti;

import java.util.Calendar;

/**
 * Simple Date class to store the tuple (year, month, day).
 *
 * Days and months start at index 1. So sunday is 1, Baisakh is 1 and January is 1.
 */
public class Date {

    /// Year this date is contained in.
    public int year=0;

    /// Month this date in contained in. Starts at index 1.
    public int month=0;

    // Day of the month this date represents. Starts at index 1.
    public int day=0;

    /**
     * Create a new Date instance.
     * @param year Year this date is contained in.
     * @param month Month of the year starting at 1.
     * @param day Day of the month starting at 1.
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Create a new Date instance from Calendar instance.
     * @param calendar Calendar whose data is used to figure out year, month and day values.
     */
    public Date(Calendar calendar) {
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Get Calendar instance representing this date, considering that this date is in English.
     * @return Calendar instance corresponding to this English date.
     */
    public Calendar getCalendar() {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(year, month - 1, day);
        return c;

    }

    /**
     * Convert this date to Nepali date, considering that this one is in English.
     * @return Corresponding Nepali date for this English date.
     */
    public Date convertToNepali() {
        return DateUtils.getNepaliDate(this);
    }

    /**
     * Convert this date to English date, considering that this one is in Nepali.
     * @return Corresponding English date for this Nepali date.
     */
    public Date convertToEnglish() { return DateUtils.getEnglishDate(this); }

    /**
     * Get the number of days from this date to a new date.
     * @param newDate Last date till which number of days is calculated.
     * @return (this - newDate) as number of days
     */
    public int getDaysTill(Date newDate) {
        return (int)((newDate.getCalendar().getTimeInMillis()
                - getCalendar().getTimeInMillis())
                / (24*60*60*1000))+1;
    }

    /**
     * Convert to simple string representation of this date.
     * @return String in format yyyy/MMMM/dd.
     */
    @Override
    public String toString() {
        return year+"/"+month+"/"+day;
    }
}
