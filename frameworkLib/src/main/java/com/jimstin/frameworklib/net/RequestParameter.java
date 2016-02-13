package com.jimstin.frameworklib.net;

/**
 * Created by jim on 16-2-13.
 */
public class RequestParameter {
    private String key;
    private String value;

    public RequestParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
