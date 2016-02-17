package com.jimstin.frameworklib.net;

import com.jimstin.frameworklib.utils.DebugUtil;

import java.util.ArrayList;

/**
 * Created by jim on 16-2-13.
 */
public class RequestManager {
    private ArrayList<HttpRequest> requestList = new ArrayList<HttpRequest>();

    public void cancelRequest() {
        DebugUtil.logInfo("cancelRequest");

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

}