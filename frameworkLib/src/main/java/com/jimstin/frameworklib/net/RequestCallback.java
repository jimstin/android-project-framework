package com.jimstin.frameworklib.net;

/**
 * Created by jim on 16-2-13.
 */
public interface RequestCallback {
    void onSuccess(Response response);
    void onFail(Response response);
}
