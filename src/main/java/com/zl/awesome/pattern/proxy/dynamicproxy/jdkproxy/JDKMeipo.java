package com.zl.awesome.pattern.proxy.dynamicproxy.jdkproxy;

import com.zl.awesome.pattern.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: netposa
 * @Date: 2020/12/4 10:11
 * @Description:
 */
public class JDKMeipo implements InvocationHandler {
    private Person target;
    public  Object getInstance(Person person)throws Exception{
        this.target=person;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    private void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    private  void after(){
        System.out.println("OK的话，准备办事");
    }
}
