package com.zl.awesome.pattern.proxy.staticproxy;

import com.zl.awesome.pattern.proxy.Person;

/**
 * @author: netposa
 * @Date: 2020/12/3 16:46
 * @Description:
 */
public class Son implements Person {
    @Override
    public void findLove(){
        System.out.println("儿子要求：肤白貌美大长腿");
    }
}
