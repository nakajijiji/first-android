package com.example.mayuhei.helloworld.com.example.mayuhei.helloworld.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mayuhei.helloworld.com.example.mayuhei.helloworld.activity.ExampleFragment;

/**
 * Created by mayuhei on 2016/12/09.
 */

public class ExampleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Activity activity;

    public ExampleFragmentPagerAdapter(FragmentManager manager){
       super(manager);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "ページ" + (position + 1);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return ExampleFragment.newInstance(android.R.color.holo_blue_bright, 0);
            case 1:
                return ExampleFragment.newInstance(android.R.color.holo_green_light, 1);
            case 2:
                return ExampleFragment.newInstance(android.R.color.holo_red_light, 2);
            case 3:
                return ExampleFragment.newInstance(android.R.color.holo_orange_light, 3);
            case 4:
                return ExampleFragment.newInstance(android.R.color.holo_purple, 4);

        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
