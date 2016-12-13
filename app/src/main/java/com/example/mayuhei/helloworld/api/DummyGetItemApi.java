package com.example.mayuhei.helloworld.api;

import com.example.mayuhei.helloworld.entity.Channel;
import com.example.mayuhei.helloworld.entity.GetItemRequest;
import com.example.mayuhei.helloworld.entity.GetItemResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayuhei on 2016/12/13.
 */

public class DummyGetItemApi implements GetItemApi {
    @Override
    public GetItemResult getItem(GetItemRequest request) {
        GetItemResult result = new GetItemResult();
        List<Channel> channels = new ArrayList<>();
        channels.add(channel("服"));
        channels.add(channel("ズボン"));
        channels.add(channel("靴"));
        channels.add(channel("絵本"));
        channels.add(channel("おもちゃ"));
        result.setChannels(channels);
        return result;
    }

    private Channel channel(String name){
        Channel result = new Channel();
        result.setName(name);
        return result;
    }
}
