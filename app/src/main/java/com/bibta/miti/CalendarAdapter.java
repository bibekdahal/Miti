package com.bibta.miti;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Adapter to set contents of calendar grid view.
 */
public class CalendarAdapter extends BaseAdapter {
    private Date mDate;
    private Date mToday;
    private int mExtraDays = 0;
    private final Context mContext;

    /**
     * Create an adapter with given context and date.
     * @param context Context containing the grid view.
     * @param date Date containing year and month to display.
     */
    public CalendarAdapter(Context context, Date date) {
        mContext = context;
        changeDate(date);
    }

    /**
     * Change calendar to another month.
     * @param date Date containing year and month to display.
     */
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

    private class ViewHolder {
        TextView nepDate;
        TextView engDate;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_date, parent, false);
            holder = new ViewHolder();

            holder.nepDate = (TextView)convertView.findViewById(R.id.nepaliDate);
            holder.engDate = (TextView)convertView.findViewById(R.id.englishDate);
            holder.imageView = (ImageView)convertView.findViewById(R.id.circle_back);

            convertView.setTag(holder);
        } else
            holder = (ViewHolder)convertView.getTag();

        TextView nepDate = holder.nepDate;
        TextView engDate = holder.engDate;
        ImageView imageView = holder.imageView;

        // Set text

        // Days
        if (position >= mExtraDays) {
            int dt = (position + 1 - mExtraDays);
            nepDate.setText(NepaliTranslator.getNumber(dt + ""));

            Date nepaliDate = new Date(mDate.year, mDate.month, dt);
            String dt2 = nepaliDate.convertToEnglish().day + "";
            engDate.setText(dt2);
            engDate.setVisibility(View.VISIBLE);
        }
        else {
            nepDate.setText("");
            engDate.setVisibility(View.GONE);
        }

        // Set background and colors


        if (position % 7 == 6) {
            nepDate.setTextColor(ThemeUtils.getThemeColor(mContext,
                    android.R.attr.textColorTertiary));
            engDate.setTextColor(ThemeUtils.getThemeColor(mContext,
                    android.R.attr.textColorTertiary));
        }
        else {
            nepDate.setTextColor(ThemeUtils.getThemeColor(mContext,
                    android.R.attr.textColor));
            engDate.setTextColor(ThemeUtils.getThemeColor(mContext,
                    android.R.attr.textColorSecondary));
        }

        imageView.setColorFilter(ThemeUtils.getThemeColor(mContext, R.attr.colorAccent));

        // Today
        if (mDate.year == mToday.year && mDate.month == mToday.month
                && position == mToday.day-1+mExtraDays)
            imageView.setVisibility(View.VISIBLE);
        else
            imageView.setVisibility(View.GONE);


        // Set view height equal to width and text size respectively

        final View finalRootView = convertView;
        finalRootView.post(new Runnable() {
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
