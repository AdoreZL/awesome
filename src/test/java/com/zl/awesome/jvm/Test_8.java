package com.zl.awesome.jvm;

/**
 * @author: netposa
 * @Date: 2021/1/4 09:20
 * @Description:
 */
public class Test_8 {
    static {
        System.out.println("Test_8 Static Block");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.zl.awesome.jvm.Test_1_A");
    }
}
