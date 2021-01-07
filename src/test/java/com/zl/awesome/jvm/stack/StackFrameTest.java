package com.zl.awesome.jvm.stack;

/**
 * @author: netposa
 * @Date: 2021/1/7 09:59
 * @Description:
 */
public class StackFrameTest {
    public static void main(String[] args) {
    }

    public void method1(){
        System.out.println("method1开始执行，，，");
        method2();
        System.out.println("method2开始执行，，，");
    }

    private void method2() {
        System.out.println("method2开始执行，，，");
        method3();
        System.out.println("method3开始执行，，，");
    }

    private void method3() {
        System.out.println("method2开始执行，，，");
        method3();
        System.out.println("method3开始执行，，，");
    }
}
