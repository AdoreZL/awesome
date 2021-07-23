package com.zl.awesome.pattern.singleton.test;

/**
 * @author: netposa
 * @Date: 2020/11/30 11:37
 * @Description:
 */
public class LazySimpleSingleTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();

        System.out.println("Exctor End");
    }
}
