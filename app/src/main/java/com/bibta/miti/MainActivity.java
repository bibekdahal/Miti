package com.bibta.miti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    NepaliCalendarAdapter mAdapter;
    GridView mCalendar;
    NepaliDate.Date mCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NepaliDate.Date today = new NepaliDate.Date(Calendar.getInstance()).convertToNepali();
        mAdapter = new NepaliCalendarAdapter(this, today);
        mCurrentDate = today;

        mCalendar = (GridView)findViewById(R.id.calendar);
        mCalendar.setAdapter(mAdapter);

        changeTitle();

        findViewById(R.id.prevMonth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentDate.month == 1) {
                    mCurrentDate.year--;
                    mCurrentDate.month = 12;
                } else
                    mCurrentDate.month--;

                mAdapter.changeDate(mCurrentDate);

                changeTitle();
            }
        });

        findViewById(R.id.nextMonth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentDate.month == 12) {
                    mCurrentDate.year++;
                    mCurrentDate.month = 1;
                }
                else
                    mCurrentDate.month++;

                mAdapter.changeDate(mCurrentDate);

                changeTitle();
            }
        });
    }

    private void changeTitle() {
        String title = NepaliTranslator.getNumber(mCurrentDate.year + "") + " " +NepaliTranslator.getMonth(mCurrentDate.month);
        ((TextView)findViewById(R.id.title)).setText(title);
    }
}
