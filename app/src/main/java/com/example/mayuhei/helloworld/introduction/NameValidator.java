package com.example.mayuhei.helloworld.introduction;

import com.example.mayuhei.helloworld.entity.Baby;

/**
 * Created by mayuhei on 2016/12/18.
 */

public class NameValidator implements Validator {
    @Override
    public Status handle(UserProfile profile) {
        Baby baby = profile.getBaby();
        String name = baby.getName();
        if(name == null || name.equals("")){
            Status response = Status.INVALID;
            response.setMsg("name is empty");
            return response;
        }
        return Status.VALID;
    }
}
