package com.zl.awesome.jvm.bytecode;

/**
 * @author: netposa
 * @Date: 2021/1/5 10:39
 * @Description:
 */
public class ClassInitTest {
    static {
        num = 2;
        number = 20;
    }

    private static int num = 1;
    //linking之prepare: number = 0 --> initial:20 -->10
    private static int number = 10;
    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);
        System.out.println(ClassInitTest.number);
    }
}
