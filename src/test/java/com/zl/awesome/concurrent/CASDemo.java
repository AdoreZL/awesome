package com.zl.awesome.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: netposa
 * @Date: 2021/6/17 11:23
 * @Description:
 * 1. CAS是什么 ？ ===》compareAndSet
 */
public class CASDemo {
    public static void main(String[] args) {
        //给定初始值为5
        AtomicInteger atomicInteger = new AtomicInteger(5);
        //main do thing....
        System.out.println(atomicInteger.compareAndSet(5, 2021)+"\t current data:"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current data:"+atomicInteger.get());
    }
}
