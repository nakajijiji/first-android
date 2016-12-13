package com.example.mayuhei.helloworld.api;

import com.example.mayuhei.helloworld.entity.Channel;
import com.example.mayuhei.helloworld.entity.GetItemRequest;
import com.example.mayuhei.helloworld.entity.GetItemResult;
import com.example.mayuhei.helloworld.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayuhei on 2016/12/13.
 */

public class DummyGetItemApi_V2 implements GetItemApi {
    @Override
    public GetItemResult getItem(GetItemRequest request) {
        GetItemResult result = new GetItemResult();
        List<Channel> channels = new ArrayList<>();
        channels.add(channel("服", 0));
        channels.add(channel("ズボン", 1));
        channels.add(channel("靴", 2));
        channels.add(channel("絵本", 3));
        channels.add(channel("おもちゃ", 4));
        result.setChannels(channels);
        return result;
    }

    private Channel channel(String name, int id){
        Channel result = new Channel();
        result.setName(name);
        result.setItems(getAllItemObject(id));
        return result;
    }

    private List<Item> getAllItemObject(int id){
        List<Item> items = new ArrayList<>();
        if(id == 0) {
            items.add(new Item("AAA", "baby-sample2.jpg"));
            items.add(new Item("BBB", "baby-sample2.jpg"));
            items.add(new Item("CCC", "baby-sample2.jpg"));
            items.add(new Item("DDD", "baby-sample2.jpg"));
            items.add(new Item("EEE", "baby-sample2.jpg"));
            items.add(new Item("FFF", "baby-sample2.jpg"));
            items.add(new Item("GGG", "baby-sample2.jpg"));
            items.add(new Item("HHH", "baby-sample2.jpg"));
            items.add(new Item("III", "baby-sample2.jpg"));
        }else{
            items.add(new Item("AAA", "baby-sample.jpeg"));
            items.add(new Item("BBB", "baby-sample.jpeg"));
            items.add(new Item("CCC", "baby-sample.jpeg"));
            items.add(new Item("DDD", "baby-sample.jpeg"));
            items.add(new Item("EEE", "baby-sample.jpeg"));
            items.add(new Item("FFF", "baby-sample.jpeg"));
            items.add(new Item("GGG", "baby-sample.jpeg"));
            items.add(new Item("HHH", "baby-sample.jpeg"));
            items.add(new Item("III", "baby-sample.jpeg"));
        }
        return items;
    }
}
