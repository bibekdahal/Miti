package com.bibta.miti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class CalendarAdapter extends BaseAdapter {
    private Date mDate;
    private Date mToday;
    private int mExtraDays = 0;
    private final Context mContext;

    public CalendarAdapter(Context context, Date date) {
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
                + mExtraDays;
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_date, parent, false);
        }

        TextView textView1 = (TextView)convertView.findViewById(R.id.nepaliDate);
        TextView textView2 = (TextView)convertView.findViewById(R.id.englishDate);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.circle_back);

        // Set text

        // Days
        if (position >= mExtraDays) {
            int dt = (position + 1 - mExtraDays);
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


        if (position % 7 == 6) {
            textView1.setTextColor(0xFF888888);
            textView2.setTextColor(0xFF888888);
        }
        else {
            textView1.setTextColor(0xFFFFFFFF);
            textView2.setTextColor(0xFFAAAAAA);
        }

        // Today
        if (mDate.year == mToday.year && mDate.month == mToday.month
                && position == mToday.day-1+mExtraDays)
            imageView.setVisibility(View.VISIBLE);
        else
            imageView.setVisibility(View.GONE);


        // Set view height equal to width and text size respectively

        final View finalRootView = convertView;
        convertView.post(new Runnable() {
            @Override
            public void run() {

                // Set height == width
                ViewGroup.LayoutParams params = finalRootView.getLayoutParams();
                params.height = finalRootView.getWidth()+2;

                finalRootView.setLayoutParams(params);
                finalRootView.invalidate();
            }
        });

        return convertView;
    }
}
