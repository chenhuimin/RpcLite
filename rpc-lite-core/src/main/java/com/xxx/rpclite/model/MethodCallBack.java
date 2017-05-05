package com.xxx.rpclite.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 方法调用回调类
 *
 * @author ChenHuiMin@saicmotor.com
 * @date 2017-05-05 16:31
 */

public class MethodCallBack {
    private static final Logger logger = LoggerFactory.getLogger(MethodCallBack.class);
    private static final int DEFAULT_TIMEOUT = 30;

    private MethodRequest request;
    private MethodResponse response;
    private Lock lock = new ReentrantLock();
    private Condition complete = lock.newCondition();
    private int timeout;

    public MethodCallBack(MethodRequest request) {
        this.request = request;
        this.timeout = request.getTimeout();
        if (timeout <= 0) {
            timeout = DEFAULT_TIMEOUT;
        }
    }

    public MethodResponse await() throws InterruptedException {
        try {
            lock.lock();
            complete.await(timeout, TimeUnit.SECONDS);
            return this.response;
        } catch (Exception e) {
            logger.error("Should Never Happen Error: {}", e);
            return this.response;
        } finally {
            lock.unlock();
        }
    }

    public void signal(MethodResponse response) {
        try {
            lock.lock();
            complete.signal();
            this.response = response;
        } catch (Exception e) {
            logger.error("Should Never Happen Error: {}", e);
        } finally {
            lock.unlock();
        }
    }


}
