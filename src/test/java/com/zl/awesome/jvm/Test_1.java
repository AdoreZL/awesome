package com.zl.awesome.jvm;

/**
 * @author: netposa
 * @Date: 2020/12/31 17:21
 * @Description:
 */
public class Test_1 {
    public static void main(String[] args) {
        System.out.println(new Test_1_B().str);
    }
}

class Test_1_A{
    static {
        System.out.println("A Static Block");
    }
}

class Test_1_B extends Test_1_A{
    public String str = "A str";
    static {
        System.out.println("B Static Block");
    }
}