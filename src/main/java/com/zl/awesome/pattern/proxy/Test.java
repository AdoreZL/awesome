package com.zl.awesome.pattern.proxy;

import com.zl.awesome.pattern.proxy.cglib.AliSmsService;
import com.zl.awesome.pattern.proxy.cglib.CglibProxyFactory;
import com.zl.awesome.pattern.proxy.jdkproxy.JdkProxyFactory;

/**
 * @author: netposa
 * @Date: 2021/4/17 22:39
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        //静态代理
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
        //jdk动态代理
        SmsService smsServices = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsServices.send("java");
        //cglib代理
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}
