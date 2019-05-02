package com.lmk.android_044_navigation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lmk.android_044_navigation.FragmentOne;
import com.lmk.android_044_navigation.FragmentThree;
import com.lmk.android_044_navigation.FragmentTwo;

public class PagerAdapter extends FragmentStatePagerAdapter {


    int numTabs;

    public PagerAdapter(FragmentManager fm,int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    @Override
    public Fragment getItem(int i) {
        //根据tab的序号进行选中fragment
        switch (i){
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
