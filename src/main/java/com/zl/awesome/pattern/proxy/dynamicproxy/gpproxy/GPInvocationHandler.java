package com.zl.awesome.pattern.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

/**
 * @author: netposa
 * @Date: 2020/12/4 11:13
 * @Description:
 */
public interface  GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
