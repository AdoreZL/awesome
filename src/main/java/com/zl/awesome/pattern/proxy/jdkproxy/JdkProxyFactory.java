package com.zl.awesome.pattern.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author: netposa
 * @Date: 2021/4/17 22:43
 * @Description:
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                // 目标类的类加载
                target.getClass().getClassLoader(),
                // 代理需要实现的接口，可指定多个
                target.getClass().getInterfaces(),
                // 代理对象对应的自定义 InvocationHandler
                new DebugInvocationHandler(target)
        );
    }
}
