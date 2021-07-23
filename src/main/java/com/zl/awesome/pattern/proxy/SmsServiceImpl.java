package com.zl.awesome.pattern.proxy;

/**
 * @author: netposa
 * @Date: 2021/4/17 22:37
 * @Description:
 */
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
