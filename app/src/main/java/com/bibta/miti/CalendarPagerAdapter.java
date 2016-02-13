package com.bibta.miti;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CalendarPagerAdapter extends FragmentStatePagerAdapter {
    public CalendarPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        int year = position/12 + DateUtils.startNepaliYear;
        int month = position%12 + 1;
        CalendarFragment cf = new CalendarFragment();
        cf.set(year, month);
        return cf;
    }

    @Override
    public int getCount() {
        return 91*12;
    }
}
