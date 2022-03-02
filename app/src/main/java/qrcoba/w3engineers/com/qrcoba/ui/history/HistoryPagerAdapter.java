package qrcoba.w3engineers.com.qrcoba.ui.history;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import qrcoba.w3engineers.com.qrcoba.ui.generatehistory.GenerateHistoryFragment;
import qrcoba.w3engineers.com.qrcoba.ui.scanhistory.ScanHistoryFragment;

public class HistoryPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> mFragmentsList;

    public HistoryPagerAdapter(FragmentManager fm,List<Fragment> fragments,List<String> fragmentsList) {
        super(fm);
        this.fragments=fragments;
        this.mFragmentsList=fragmentsList;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return GenerateHistoryFragment.newInstance();
            case 1:
                return ScanHistoryFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentsList.get(position);
    }
}
