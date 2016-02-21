package com.bibta.miti;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class CalendarHeaderAdapter extends BaseAdapter {
    private final Context mContext;

    public CalendarHeaderAdapter(Context context) {
        mContext = context;
    }


    @Override
    public int getCount() {
        return 7;
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

        TextView textView1 = (TextView)convertView.findViewById(R.id.nepaliDate);
        TextView textView2 = (TextView)convertView.findViewById(R.id.englishDate);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.circle_back);

        // Set text

        // Day headers
        textView1.setText(NepaliTranslator.getShortDay(position));
        textView2.setVisibility(View.GONE);


        // Set background and colors

        imageView.setVisibility(View.GONE);
        textView1.setBackgroundResource(R.drawable.border_bottom);

        if (position == 6) {
            textView1.setTextColor(0xFF888888);
            textView2.setTextColor(0xFF888888);
        }

        // Set view height equal to width and text size respectively

        /*final View finalRootView = convertView;
        convertView.post(new Runnable() {
            @Override
            public void run() {

                // Set height == width
                ViewGroup.LayoutParams params = finalRootView.getLayoutParams();
                params.height = finalRootView.getWidth()+2;

                finalRootView.setLayoutParams(params);
                finalRootView.invalidate();
            }
        });*/

        return convertView;
    }
}
