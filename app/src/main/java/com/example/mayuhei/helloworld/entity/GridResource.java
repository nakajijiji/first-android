package com.example.mayuhei.helloworld.entity;

import java.util.Map;

/**
 * Created by mayuhei on 2016/12/13.
 */

public class GridResource {
    private Map<Integer, Channel> idToChannel;

    public GridResource(Map<Integer, Channel> idToChannel){
        this.idToChannel = idToChannel;
    }

    public void setIdToChannel(Map<Integer, Channel> idToChannel){
        this.idToChannel = idToChannel;
    }

    public Map<Integer, Channel> getIdToChannels(){
        return idToChannel;
    }
}
