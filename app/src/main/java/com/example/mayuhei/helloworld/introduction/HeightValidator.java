package com.example.mayuhei.helloworld.introduction;


/**
 * Created by mayuhei on 2016/12/18.
 */

public class HeightValidator implements Validator {
    @Override
    public Status handle(UserProfile profile) {
        return Status.VALID;
    }
}
