package com.example.mayuhei.helloworld.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mayuhei.helloworld.activity.ExampleFragment;

import java.util.List;

/**
 * Created by mayuhei on 2016/12/13.
 */

public class DefaultPagerAdapter extends FragmentPagerAdapter {
    private List<String> tabNameList;

    public DefaultPagerAdapter(FragmentManager fm, List<String> tabNameList) {
        super(fm);
        this.tabNameList = tabNameList;
    }

    @Override
    public Fragment getItem(int position) {
        return ExampleFragment.newInstance(getColor(position), position);
    }

    @Override
    public int getCount() {
        return tabNameList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNameList.get(position);
    }

    private int getColor(int position){
        int key = position%3;
        switch (key){
            case 0:
                return android.R.color.holo_blue_bright;
            case 1:
                return android.R.color.holo_green_light;
            case 2:
                return android.R.color.holo_red_light;
        }
        return -1;
    }

    public List<String> getTabNameList() {
        return tabNameList;
    }

    public void setTabNameList(List<String> tabNameList) {
        this.tabNameList = tabNameList;
    }
}
