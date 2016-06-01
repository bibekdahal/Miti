package com.bibta.miti;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class TithiFragment extends Fragment {
    private Date mCurrentDate = new Date(2000, 1, 1);

    private TithiAdapter mTithiAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tithi, container, false);
        changeTitle(view);

        // Get the recycler view for mitis.

        RecyclerView tithiList = (RecyclerView) view.findViewById(R.id.events_list);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        tithiList.setLayoutManager(llm);
        mTithiAdapter = new TithiAdapter(getContext());
        tithiList.setAdapter(mTithiAdapter);
        refreshMitis();

        return view;
    }

    private void changeTitle(View view) {
        String nepali = NepaliTranslator.getNumber(mCurrentDate.year + "") + " "
                + NepaliTranslator.getMonth(mCurrentDate.month);

        Date eDate1 = new Date(mCurrentDate.year, mCurrentDate.month, 1).convertToEnglish();
        Date eDate2 = new Date(mCurrentDate.year, mCurrentDate.month, 26).convertToEnglish();

        String english = getEnglishMonth(eDate1.month) + "/"
                + getEnglishMonth(eDate2.month);
        english += " " + eDate1.year + (eDate1.year == eDate2.year ? "" : "/" + eDate2.year);

        String monthYear = nepali + "\n" + english;
        ((TextView) view.findViewById(R.id.monthYear)).setText(monthYear);

        view.findViewById(R.id.calendar_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).toggleCalendar();
            }
        });
    }

    private void refreshMitis() {
        if (mTithiAdapter != null) {
            mTithiAdapter.setDate(mCurrentDate.year, mCurrentDate.month);
        }
    }

    private static String getEnglishMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, month - 1);
        return calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
    }

    /**
     * Set year and month for this calendar.
     *
     * @param year  Year to display.
     * @param month Month to display.
     */
    public void set(int year, int month) {
        mCurrentDate.year = year;
        mCurrentDate.month = month;
        refreshMitis();
    }
}
