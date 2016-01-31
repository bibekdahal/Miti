package com.bibta.miti;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CalendarPagerAdapter extends FragmentStatePagerAdapter {
    public static final List<Fragment> fragments = new ArrayList<>();
    public CalendarPagerAdapter(FragmentManager manager) {
        super(manager);

        for (int i=0; i<=90; ++i) {
            for (int j=1; j<=12; ++j) {
                CalendarFragment cf = new CalendarFragment();
                cf.set(i+DateUtils.startNepaliYear, j);
                fragments.add(cf);
            }
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
