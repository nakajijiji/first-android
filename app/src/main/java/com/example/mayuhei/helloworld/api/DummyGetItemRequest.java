package com.example.mayuhei.helloworld.api;

import com.example.mayuhei.helloworld.entity.Baby;
import com.example.mayuhei.helloworld.entity.GetItemRequest;

import java.sql.Timestamp;

/**
 * Created by mayuhei on 2016/12/13.
 */

public class DummyGetItemRequest extends GetItemRequest{
    public DummyGetItemRequest(){
        Baby baby = new Baby();
        baby.setGender(Baby.Gender.MALE);
        Baby.Birthday birthday = new Baby.Birthday();
        birthday.setYear(2014);
        birthday.setMonth(11);
        birthday.setDay(5);

        baby.setName("そういちろう");

        Baby.Size size = new Baby.Size();
        size.setValue(86);
        size.setTimestamp(0);
        this.setBaby(baby);
    }
}
