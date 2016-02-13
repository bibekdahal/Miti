package com.bibta.miti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class CalendarFragment extends Fragment {

    CalendarAdapter mAdapter;
    GridView mCalendar;
    Date mCurrentDate = new Date(2000, 1, 1);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        mAdapter = new CalendarAdapter(getContext(), mCurrentDate);
        changeTitle(view);

        mCalendar = (GridView)view.findViewById(R.id.calendar);
        mCalendar.setAdapter(mAdapter);

        // Set vertical spacing of calendar according to display height
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mCalendar.setVerticalSpacing((int)(metrics.heightPixels/800f*17f));

        return view;
    }

    private void changeTitle(View view) {
        String nepali = NepaliTranslator.getNumber(mCurrentDate.year + "") + " "
                + NepaliTranslator.getMonth(mCurrentDate.month);
        ((TextView)view.findViewById(R.id.nepaliMonthYear)).setText(nepali);

        Date eDate1 = new Date(mCurrentDate.year, mCurrentDate.month, 1).convertToEnglish();
        Date eDate2 = new Date(mCurrentDate.year, mCurrentDate.month, 26).convertToEnglish();

        String english = getEnglishMonth(eDate1.month) + "/"
                + getEnglishMonth(eDate2.month);
        english += " " + eDate1.year + (eDate1.year==eDate2.year?"":"/"+eDate2.year);
        ((TextView)view.findViewById(R.id.englishMonthYear)).setText(english);
    }

    public static String getEnglishMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, month - 1);
        return calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
    }

    public void set(int year, int month) {
        mCurrentDate.year = year;
        mCurrentDate.month = month;

        if (mAdapter != null)
            mAdapter.changeDate(mCurrentDate);
    }
}
