package com.zl.awesome.pattern.proxy.cglib;

/**
 * @author: netposa
 * @Date: 2021/4/17 22:48
 * @Description:
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
