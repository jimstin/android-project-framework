package com.jimstin.frameworklib.net;

import java.util.ArrayList;

/**
 * Created by jim on 16-2-13.
 */
public class RequestInPack {
    private String url;
    private ArrayList<RequestParameter> parameters;
    private RequestCallback callback;


    public RequestInPack(String url, ArrayList<RequestParameter> parameters,
                         RequestCallback callback) {
        this.url = url;
        this.parameters = parameters;
        this.callback = callback;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<RequestParameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<RequestParameter> parameters) {
        this.parameters = parameters;
    }

    public RequestCallback getCallback() {
        return callback;
    }

    public void setCallback(RequestCallback callback) {
        this.callback = callback;
    }
}
