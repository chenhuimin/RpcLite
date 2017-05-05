package com.xxx.rpclite.model;

import java.io.Serializable;

/**
 * 方法调用请问类
 *
 * @author ChenHuiMin@saicmotor.com
 * @date 2017-05-05 16:20
 */

public class MethodRequest implements Serializable, Cloneable {
    private String id;
    private String serviceName;
    private String methodName;
    private Object[] parameterValues;

    private Integer timeout;
    private Integer retry;

    public MethodRequest() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameterValues() {
        return parameterValues;
    }

    public void setParameterValues(Object[] parameterValues) {
        this.parameterValues = parameterValues;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getRetry() {
        return retry;
    }

    public void setRetry(Integer retry) {
        this.retry = retry;
    }
}
