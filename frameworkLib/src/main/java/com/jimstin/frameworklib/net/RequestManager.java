package com.jimstin.frameworklib.net;

import java.util.ArrayList;

/**
 * Created by jim on 16-2-13.
 */
public class RequestManager {
    private ArrayList<HttpRequest> requestList = new ArrayList<HttpRequest>();

    public void cancelRequest() {
        if (requestList != null && requestList.size() > 0) {
            for (HttpRequest request : requestList) {
                request.abort();
            }
            requestList.clear();
        }
    }

    public ArrayList<HttpRequest> getRequestList() {
        return requestList;
    }

    public void login(RequestCallback callback) {
        String url = "";
        ArrayList<RequestParameter> requestParameters =
                new ArrayList<RequestParameter>();
        RequestInPack inpack = new RequestInPack(url, requestParameters, callback);
        HttpRequest httpRequest = new HttpRequest(HttpRequest.METHOD_POST, inpack, this);
        DefaultThreadPool.getInstance().addRequest(httpRequest);
    }
}