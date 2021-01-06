package com.zl.awesome.jvm.bytecode;

/**
 * @author: netposa
 * @Date: 2021/1/5 11:03
 * @Description:
 */
public class ClinitTest {
    private int a =1;
    private static int c =3;
    public static void main(String[] args) {
        int b = 2;
    }

    ClinitTest(){
        a = 10;
        int d = 20;
    }
}
