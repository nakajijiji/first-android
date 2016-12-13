package com.example.mayuhei.helloworld.api;

import com.example.mayuhei.helloworld.entity.GetItemRequest;
import com.example.mayuhei.helloworld.entity.GetItemResult;

/**
 * Created by mayuhei on 2016/12/13.
 */

public interface GetItemApi {
    GetItemResult getItem(GetItemRequest request);
}
