package com.example.mayuhei.helloworld.handler;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;

import com.example.mayuhei.helloworld.adapter.DefaultPagerAdapter;
import com.example.mayuhei.helloworld.entity.Channel;
import com.example.mayuhei.helloworld.entity.GetItemResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayuhei on 2016/12/13.
 */

public class UpdateTabView implements GetItemResultHandler {
    private ViewPager viewPager;

    public UpdateTabView(ViewPager viewPager){
        this.viewPager = viewPager;
    }

    @Override
    public void handle(GetItemResult result) {
        DefaultPagerAdapter adapter = (DefaultPagerAdapter)viewPager.getAdapter();
        List<Channel> channels = result.getChannels();
        List<String> nameList = new ArrayList<>();
        for(Channel c : channels){
            nameList.add(c.getName());
        }
        adapter.setTabNameList(nameList);
        adapter.notifyDataSetChanged();
        viewPager.invalidate();
    }
}
