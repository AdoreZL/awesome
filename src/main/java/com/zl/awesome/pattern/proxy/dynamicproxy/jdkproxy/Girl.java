package com.zl.awesome.pattern.proxy.dynamicproxy.jdkproxy;

import com.zl.awesome.pattern.proxy.Person;

/**
 * @author: netposa
 * @Date: 2020/12/4 10:08
 * @Description:
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
