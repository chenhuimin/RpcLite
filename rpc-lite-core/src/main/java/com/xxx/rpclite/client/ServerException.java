package com.xxx.rpclite.client;

import com.xxx.rpclite.model.MethodStatus;

/**
 * 服务端错误
 *
 * @author ChenHuiMin@saicmotor.com
 * @date 2017-05-05 16:11
 */

public class ServerException extends RuntimeException {


    private Integer errorCode;

    private String errorMsg;

    public ServerException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public ServerException(MethodStatus status, String errorMsg) {
        super(errorMsg);
        this.errorCode = status.getStatus();
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
