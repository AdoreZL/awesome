package com.zl.awesome.jvm;

/**
 * @author: netposa
 * @Date: 2021/1/4 09:00
 * @Description: final修饰，将常量str写入常量池中
 */
public class Test_6 {
    public static void main(String[] args) {
        System.out.println(Test_6_A.str );
    }
}

class Test_6_A{
    public static final String str = "A str";

    static {
        System.out.println("Test_6_A Static Block");
    }
}