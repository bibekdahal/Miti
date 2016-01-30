package com.bibta.miti;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Calendar;

public class NepaliCalendarAdapter extends BaseAdapter {
    private NepaliDate.Date mDate;
    private NepaliDate.Date mToday;
    private int mExtraDays = 0;
    private final Context mContext;

    public NepaliCalendarAdapter(Context context, NepaliDate.Date date) {
        mContext = context;
        changeDate(date);
    }

    public void changeDate(NepaliDate.Date date) {
        mDate = date;

        NepaliDate.Date temp = new NepaliDate.Date(mDate.year, mDate.month, 1);
        Calendar engCalendar = temp.convertToEnglish().getCalendar();
        mExtraDays = engCalendar.get(Calendar.DAY_OF_WEEK)-1;
        notifyDataSetInvalidated();

        mToday = new NepaliDate.Date(Calendar.getInstance()).convertToNepali();
    }

    @Override
    public int getCount() {
        return NepaliDate.getNumDays(mDate.year, mDate.month)
                + mExtraDays + 7;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null ) {
            textView = new TextView(mContext);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(14);
            textView.setPadding(2, 2, 2, 2);
        }
        else
            textView = (TextView)convertView;

        if (position < 7) {
            textView.setText(NepaliTranslator.getShortDay(position));
        }
        else if (position >= mExtraDays+7) {
            String date = NepaliTranslator.getNumber("" + (position + 1 - mExtraDays - 7));
            textView.setText(date);
        }
        else
            textView.setText("");


        if (position < 7) {
            textView.setBackgroundColor(Color.parseColor("#BB000000"));
            textView.setTextColor(Color.parseColor("#BBFFFFFF"));
        } else {
            textView.setBackgroundColor(Color.parseColor("#333333"));

            if (mDate.year == mToday.year && mDate.month == mToday.month
                    && position == mToday.day-1+7+mExtraDays)
                textView.setTextColor(Color.parseColor("#FFDF00"));
            else if (position % 7 == 6)
                textView.setTextColor(Color.parseColor("#FF0000"));
            else
                textView.setTextColor(Color.parseColor("#FFFFFF"));
        }

        return textView;
    }
}
