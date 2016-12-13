package com.example.mayuhei.helloworld.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mayuhei.helloworld.activity.ExampleFragment;
import com.example.mayuhei.helloworld.entity.Channel;
import com.example.mayuhei.helloworld.entity.GridResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mayuhei on 2016/12/13.
 */

public class DefaultPagerAdapter extends FragmentPagerAdapter {
    private final GridResource resource;
    private Map<Integer, Fragment> fragmentMap = new HashMap<>();

    public DefaultPagerAdapter(FragmentManager fm, List<Channel> channels) {
        super(fm);
        List<GridResource> results = new ArrayList<>();
        this.resource = new GridResource(extract(channels));
    }

    @Override
    public Fragment getItem(int position) {
        Fragment result = ExampleFragment.newInstance(getColor(position), position, resource);
        fragmentMap.put(position, result);
        return result;
    }

    @Override
    public int getCount() {
        return resource.getIdToChannels().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return resource.getIdToChannels().get(position).getName();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
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

    public void updateResource(List<Channel> channels) {
        Map<Integer, Channel> map = extract(channels);
        this.resource.setIdToChannel(map);
    }

    private Map<Integer, Channel> extract(List<Channel> channels){
        Map<Integer, Channel> idToChannel = new HashMap<>();
        int i = 0;
        for(Channel c : channels){
            idToChannel.put(i, c);
            i++;
        }
        return idToChannel;
    }

}
