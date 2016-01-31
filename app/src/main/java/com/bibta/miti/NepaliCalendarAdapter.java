package com.bibta.miti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class NepaliCalendarAdapter extends BaseAdapter {
    private Date mDate;
    private Date mToday;
    private int mExtraDays = 0;
    private final Context mContext;

    public NepaliCalendarAdapter(Context context, Date date) {
        mContext = context;
        changeDate(date);
    }

    public void changeDate(Date date) {
        mDate = date;

        Date temp = new Date(mDate.year, mDate.month, 1);
        Calendar engCalendar = temp.convertToEnglish().getCalendar();
        mExtraDays = engCalendar.get(Calendar.DAY_OF_WEEK)-1;
        notifyDataSetInvalidated();

        mToday = new Date(Calendar.getInstance()).convertToNepali();
    }

    @Override
    public int getCount() {
        return DateUtils.getNumDays(mDate.year, mDate.month)
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

        if (convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_date, parent, false);

        TextView textView1 = (TextView)convertView.findViewById(R.id.nepaliDate);
        TextView textView2 = (TextView)convertView.findViewById(R.id.englishDate);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.circle_back);

        // Set text

        // Day headers
        if (position < 7) {
            textView1.setText(NepaliTranslator.getShortDay(position));
            textView2.setVisibility(View.GONE);
        }
        // Days
        else if (position >= mExtraDays+7) {
            int dt = (position + 1 - mExtraDays - 7);
            textView1.setText(NepaliTranslator.getNumber(dt + ""));

            String dt2 = new Date(mDate.year, mDate.month, dt).convertToEnglish().day + "";
            textView2.setText(dt2);
            textView2.setVisibility(View.VISIBLE);

        }
        else {
            textView1.setText("");
            textView2.setVisibility(View.GONE);
        }

        // Set background and colors

        imageView.setVisibility(View.GONE);

        // Day headers
        if (position < 7) {
            convertView.setBackgroundColor(0xBB000000);
            textView1.setTextColor(0xBBFFFFFF);
            textView1.setPadding(0,0,0,0);
        }

        // Days
        else {
            convertView.setBackgroundColor(0xFF333333);
            if (position % 7 == 6)
                textView1.setTextColor(0xFFFF0000);
            else
                textView1.setTextColor(0xFFFFFFFF);

            // Today
            if (mDate.year == mToday.year && mDate.month == mToday.month
                    && position == mToday.day-1+7+mExtraDays)
                imageView.setVisibility(View.VISIBLE);
        }

        return convertView;
    }
}
