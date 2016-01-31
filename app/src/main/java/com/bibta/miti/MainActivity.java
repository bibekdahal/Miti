package com.bibta.miti;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager)findViewById(R.id.calendarPager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new CalendarPagerAdapter(getSupportFragmentManager()));

        Date today = new Date(Calendar.getInstance()).convertToNepali();
        viewPager.setCurrentItem((today.year-DateUtils.startNepaliYear)*12+(today.month-1));
    }
}
