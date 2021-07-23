package com.zl.awesome.pattern.proxy;

/**
 * @author: netposa
 * @Date: 2021/4/17 22:37
 * @Description: 代理类同样实现接口
 */
public class SmsProxy implements SmsService{
    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }
}
