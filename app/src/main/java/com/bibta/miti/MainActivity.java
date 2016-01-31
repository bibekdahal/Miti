package com.bibta.miti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    NepaliCalendarAdapter mAdapter;
    GridView mCalendar;
    Date mCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date today = new Date(Calendar.getInstance()).convertToNepali();
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
        String nepali = NepaliTranslator.getNumber(mCurrentDate.year + "") + " "
                + NepaliTranslator.getMonth(mCurrentDate.month);
        ((TextView)findViewById(R.id.nepaliMonthYear)).setText(nepali);

        Date eDate1 = new Date(mCurrentDate.year, mCurrentDate.month, 1).convertToEnglish();
        Date eDate2 = new Date(mCurrentDate.year, mCurrentDate.month, 26).convertToEnglish();

        String english = getEnglishMonth(eDate1.month) + "/"
            + getEnglishMonth(eDate2.month);
        english += " " + eDate1.year + (eDate1.year==eDate2.year?"":"/"+eDate2.year);
        ((TextView) findViewById(R.id.englishMonthYear)).setText(english);
    }

    public static String getEnglishMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, month-1);
        return calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
    }
}
