package com.bibta.miti;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_date, parent, false);
        }

        final TextView textView1 = (TextView)convertView.findViewById(R.id.nepaliDate);
        final TextView textView2 = (TextView)convertView.findViewById(R.id.englishDate);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.circle_back);

        // Set text

        // Day headers
        if (position < 7) {
            textView1.setText(NepaliTranslator.getShortDay(position));
            textView2.setVisibility(View.GONE);
            convertView.setBackgroundResource(0);
        }
        // Days
        else if (position >= mExtraDays+7) {
            int dt = (position + 1 - mExtraDays - 7);
            textView1.setText(NepaliTranslator.getNumber(dt + ""));

            String dt2 = new Date(mDate.year, mDate.month, dt).convertToEnglish().day + "";
            textView2.setText(dt2);
            textView2.setVisibility(View.VISIBLE);


            // Set selectable background and on click listener
            int[] attrs = new int[]{R.attr.selectableItemBackground};
            TypedArray typedArray = mContext.obtainStyledAttributes(attrs);
            int backgroundResource = typedArray.getResourceId(0, 0);
            convertView.setBackgroundResource(backgroundResource);
            typedArray.recycle();


            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date selected = new Date(mDate.year, mDate.month, position - mExtraDays - 7 + 1);
                }
            });
        }
        else {
            textView1.setText("");
            textView2.setVisibility(View.GONE);
            convertView.setBackgroundResource(0);
        }

        // Set background and colors

        imageView.setVisibility(View.GONE);

        if (position < 7) {
            textView1.setBackgroundResource(R.drawable.border_bottom);
        } else {
            textView1.setBackgroundResource(0);
        }

        // rootView.setBackgroundColor(0xFF444444);
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
                && position == mToday.day-1+7+mExtraDays)
            imageView.setVisibility(View.VISIBLE);


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
