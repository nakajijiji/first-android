package com.example.mayuhei.helloworld.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by mayuhei on 2016/12/19.
 */

public class JsonSerializer {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String serialize(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T deserialize(String str, Class<T> clazz){
        try {
            return objectMapper.readValue(str, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
