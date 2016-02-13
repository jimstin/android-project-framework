package com.jimstin.frameworklib.net;

import com.jimstin.frameworklib.entity.BaseEntity;

/**
 * Created by jim on 16-2-13.
 */
public class Response {
    private boolean isError;
    private int errorType;
    private String errorMessage;
    private BaseEntity result;

    public boolean isError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public BaseEntity getResult() {
        return result;
    }

    public void setResult(BaseEntity result) {
        this.result = result;
    }
}
