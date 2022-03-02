package qrcoba.w3engineers.com.qrcoba.ui.history;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import io.reactivex.disposables.CompositeDisposable;
import qrcoba.w3engineers.com.qrcoba.R;
import qrcoba.w3engineers.com.qrcoba.databinding.FragmentHistoryBinding;

public class HistoryFragment extends Fragment {

    private Context mContext;
    private FragmentHistoryBinding mBinding;
    private CompositeDisposable mCompositeDisposable;
    private List<Fragment> fragments;

    public HistoryFragment() {

    }

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mContext != null) {
            if(fragments!=null) {
                List<String> mFragmentTitleList = new ArrayList<>();
                mFragmentTitleList.add(getResources().getString(R.string.download_history));
                mFragmentTitleList.add(getResources().getString(R.string.scan_history));
                final HistoryPagerAdapter adapter = new HistoryPagerAdapter(getChildFragmentManager(), fragments,mFragmentTitleList);


               // mBinding.tabLayout.getTabAt(0).setText(getResources().getString(R.string.download_history));
             //   mBinding.tabLayout.getTabAt(1).setText(getResources().getString(R.string.scan_history));

                mBinding.viewPager.setOffscreenPageLimit(2);
                mBinding.viewPager.setAdapter(adapter);
                mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);
                tabListener();
                pageListener();
            }
        }
    }

    private void pageListener(){
        mBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("doneYY","1");
               // mBinding.viewPager.setCurrentItem(position);
            }

            @Override
            public void onPageSelected(int position) {

                Log.d("doneYY","2");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("doneYY","3");
            }
        });
    }

    private FragmentManager fm;
    public void setFragments(List<Fragment> fragments, FragmentManager fm) {
        this.fragments = fragments;
        this.fm=fm;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    private void tabListener() {
        mBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mBinding.viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
