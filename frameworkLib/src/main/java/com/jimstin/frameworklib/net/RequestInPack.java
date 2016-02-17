package com.jimstin.frameworklib.net;

import com.jimstin.frameworklib.entity.BaseEntity;

import java.util.ArrayList;

/**
 * Created by jim on 16-2-13.
 */
public class RequestInPack {
    private UrlData urlData;
    private ArrayList<RequestParameter> parameters;
    private ArrayList<String> filePath;
    private BaseEntity baseEntity;
    private RequestCallback callback;

    public RequestInPack(UrlData urlData, ArrayList<RequestParameter> parameters,
                         BaseEntity baseEntity, RequestCallback callback) {
        this.urlData = urlData;
        this.parameters = parameters;
        this.baseEntity = baseEntity;
        this.callback = callback;
    }

    public UrlData getUrlData() {
        return urlData;
    }

    public void setUrlData(UrlData urlData) {
        this.urlData = urlData;
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

    public ArrayList<String> getFilePath() {
        return filePath;
    }

    public void setFilePath(ArrayList<String> filesPath) {
        this.filePath = filesPath;
    }

    public BaseEntity getBaseEntity() {
        return baseEntity;
    }

    public void setBaseEntity(BaseEntity baseEntity) {
        this.baseEntity = baseEntity;
    }
}
