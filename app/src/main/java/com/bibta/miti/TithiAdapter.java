package com.bibta.miti;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TithiAdapter extends RecyclerView.Adapter<TithiAdapter.EventViewHolder> {

    private Context mContext;
    private int mYear, mMonth;
    private TithiDb mDb;
    private int mToday;

    private List<Integer> mDays = new ArrayList<>();
    private List<Pair<String, String>> mEvents = new ArrayList<>();

    public TithiAdapter(Context context) {
        mContext = context;
        mDb = new TithiDb(context);
    }

    public void setDate(int year, int month) {
        mYear = year;
        mMonth = month;

        mEvents.clear();
        mDays.clear();
        for (int i=1; i<=32; ++i) {
            String date = String.format("%04d-%02d-%02d", year, month, i);

            Pair<String, String> event = mDb.get(date);
            if (event != null && !(event.first.equals("") && event.second.equals(""))) {
                mDays.add(i);
                mEvents.add(event);
            }
        }

        Date today = new Date(Calendar.getInstance()).convertToNepali();
        if (today.year == year && today.month == month)
            mToday = today.day;
        else
            mToday = -1;

        notifyDataSetChanged();
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_tithi, parent, false)
        );
    }

    @Override
    public int getItemCount() {
        return mDays.size();
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Pair<String, String> event = mEvents.get(position);
        holder.date.setText(NepaliTranslator.getNumber(mDays.get(position).toString()));
        holder.text1.setText(event.first);
        holder.text2.setText(event.second);

        if (mToday != mDays.get(position)) {
            holder.circle.setVisibility(View.INVISIBLE);
        } else {
            holder.circle.setVisibility(View.VISIBLE);
            holder.circle.setColorFilter(ThemeUtils.getThemeColor(mContext, R.attr.colorAccent));
        }
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        protected TextView date;
        protected TextView text1;
        protected TextView text2;
        protected ImageView circle;

        public EventViewHolder(View itemView) {
            super(itemView);

            date = (TextView)itemView.findViewById(R.id.event_date);
            text1 = (TextView)itemView.findViewById(R.id.event_text1);
            text2 = (TextView)itemView.findViewById(R.id.event_text2);
            circle = (ImageView)itemView.findViewById(R.id.circle_back);
        }
    }
}
