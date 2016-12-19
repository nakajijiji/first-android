package com.example.mayuhei.helloworld.introduction;

import com.example.mayuhei.helloworld.entity.Baby;

/**
 * Created by mayuhei on 2016/12/18.
 */

public class UserProfile {
    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    Baby baby;
}
