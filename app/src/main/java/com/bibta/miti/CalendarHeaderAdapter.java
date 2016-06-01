package com.bibta.miti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Adapter to display calendar header (days) in grid view.
 */
public class CalendarHeaderAdapter extends BaseAdapter {
    private final Context mContext;

    /**
     * Create header adapter in given context.
     * @param context Context containing the grid view.
     */
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
    public View getView(int position, View convertView, final ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_date_header, parent, false);

            textView = (TextView)convertView.findViewById(R.id.day_name);
            convertView.setTag(textView);
        } else
            textView = (TextView)convertView.getTag();

        textView.setText(NepaliTranslator.getShortDay(position));

        if (position == 6)
            textView.setTextColor(ThemeUtils.getThemeColor(mContext,
                    android.R.attr.textColorTertiary));
        else
            textView.setTextColor(ThemeUtils.getThemeColor(mContext, android.R.attr.textColor));

        return convertView;
    }
}
