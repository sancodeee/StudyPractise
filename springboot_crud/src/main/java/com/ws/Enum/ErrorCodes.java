package com.ws.Enum;

public enum ErrorCodes {


    TIME_OUT(405,"请求超时"),
    SERVER_ERROR(500,"服务器异常"),
    NOTFOUND_ERROR(404,"找不到资源");

    private final Integer errorCode;
    private final String errorMessage;

    private ErrorCodes(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    public Integer getErrorCode() {
        return errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }


}
