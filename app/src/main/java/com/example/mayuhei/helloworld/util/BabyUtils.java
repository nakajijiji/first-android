package com.example.mayuhei.helloworld.util;

import com.example.mayuhei.helloworld.entity.Baby;

/**
 * Created by mayuhei on 2016/12/18.
 */

public class BabyUtils {
    public static Baby.Gender toGender(String gender){
        if(gender == null){
            return null;
        }else if(gender.equals("男の子")){
            return Baby.Gender.MALE;
        }else if(gender.equals("女の子")){
            return Baby.Gender.FEMALE;
        }
        return null;
    }

    public static Baby.Size toSize(int size, int timestamp){
        Baby.Size result = new Baby.Size();
        result.setValue(size);
        result.setTimestamp(timestamp);
        return result;
    }
}
