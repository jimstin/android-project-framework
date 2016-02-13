package com.jimstin.frameworklib.net;

import java.io.Serializable;

/**
 * Created by jim on 16-2-13.
 */
public class HttpRequest implements Runnable, Serializable {

    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    /**
     * GET 或 POST
     */
    private String method;
    private RequestInPack inpack;

    public HttpRequest(String method, RequestInPack inpack,
                       RequestManager requestManager) {
        this.method = method.toUpperCase();
        this.inpack = inpack;
        requestManager.getRequestList().add(this);
    }

    public void abort() {
        DefaultThreadPool.getInstance().getTaskQuene().remove(this);
    }

    @Override
    public void run() {

    }
}
