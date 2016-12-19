package com.example.mayuhei.helloworld.introduction;

/**
 * Created by mayuhei on 2016/12/18.
 */

public interface Validator {
    Status handle(UserProfile profile);

    public static enum Status {
        VALID, INVALID;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        private String msg;

    }
}
