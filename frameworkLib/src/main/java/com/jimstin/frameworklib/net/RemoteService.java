package com.jimstin.frameworklib.net;

import com.jimstin.frameworklib.app.FrameworkApp;
import com.jimstin.frameworklib.entity.UserEntity;
import com.jimstin.frameworklib.utils.GlobalUtil;
import com.jimstin.frameworklib.utils.UrlConfigManager;

import java.util.ArrayList;

/**
 * Created by jim on 16-2-17.
 */
public class RemoteService {
    public static void login(RequestCallback callback, RequestManager requestManager) {
        ArrayList<RequestParameter> requestParameters =
                new ArrayList<RequestParameter>();
        RequestParameter requestParameter1 = new RequestParameter("phone_num", "18576430783");
        RequestParameter requestParameter2 = new RequestParameter("password", GlobalUtil.toMd5L32("000000"));
        requestParameters.add(requestParameter1);
        requestParameters.add(requestParameter2);
        UrlData urlData = UrlConfigManager.findUrlData(FrameworkApp.getContext(), "login");
        RequestInPack inpack = new RequestInPack(urlData, requestParameters, new UserEntity(), callback);
        new HttpRequest(HttpRequest.METHOD_POST, inpack, requestManager).startRequest();
    }
}
