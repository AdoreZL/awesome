package com.zl.awesome.pattern.proxy.dynamicproxy.jdkproxy;

import com.zl.awesome.pattern.proxy.Person;

/**
 * @author: netposa
 * @Date: 2020/12/4 10:36
 * @Description:
 */
public class JDKProxyTest {
    public static void main(String[] args) throws Exception {
        Person obj = (Person) new JDKMeipo().getInstance(new Girl());
        obj.findLove();
    }
}
