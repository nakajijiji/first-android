package com.example.mayuhei.helloworld.com.example.mayuhei.helloworld.entity;

import java.util.List;

/**
 * Created by mayuhei on 2016/12/13.
 */

public class Channel {
    private String identifier;
    private String name;
    private List<Item> items;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
