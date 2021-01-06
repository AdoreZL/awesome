package com.zl.awesome.jvm.bytecode;

/**
 * @author: netposa
 * @Date: 2021/1/4 11:34
 * @Description:
 */
public class Simple {
    //准备阶段：a=0 -----> initial:a=1
    private static int a = 1;

    public static void main(String[] args) {
        System.out.println(a);
    }
}
