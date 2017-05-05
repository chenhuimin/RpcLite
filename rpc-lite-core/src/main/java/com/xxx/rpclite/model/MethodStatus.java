package com.xxx.rpclite.model;

/**
 * 服务端状态码
 *
 * @author ChenHuiMin@saicmotor.com
 * @date 2017-05-05 16:12
 */

public enum MethodStatus {
    SUCCESS(200),
    FAILED(500);
    private final int status;

    MethodStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
