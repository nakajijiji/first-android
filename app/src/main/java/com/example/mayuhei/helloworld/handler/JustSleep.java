package com.example.mayuhei.helloworld.handler;

import com.example.mayuhei.helloworld.entity.GetItemResult;

/**
 * Created by mayuhei on 2016/12/13.
 */

public class JustSleep implements GetItemResultHandler{
    @Override
    public void handle(GetItemResult result) {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
