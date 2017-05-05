package com.xxx.rpclite.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcLite {

    String serviceName() default "";

    String methodName() default "";

    int timeout() default 0;

    /**
     * < 0: 表示交给框架处理，
     * = 0: 表示不重试，
     * > 0: 按照设定的次数重试。
     *
     * @return
     */
    int retry() default -1;


}
