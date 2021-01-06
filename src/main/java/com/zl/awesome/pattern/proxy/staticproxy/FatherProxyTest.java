package com.zl.awesome.pattern.proxy.staticproxy;

/**
 * @author: netposa
 * @Date: 2020/12/3 17:03
 * @Description:
 */
public class FatherProxyTest {
    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();

        //大家每天d都在用得一种静态代理得形式
        //ThreadLocal
        //进行数据源动态切换

    }
}
