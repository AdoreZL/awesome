package com.zl.awesome.jvm.stack;

/**
 * @author: netposa
 * @Date: 2021/1/6 17:27
 * @Description:
 */
public class StackErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
