package com.zl.awesome.jvm.stack;

/**
 * @author: netposa
 * @Date: 2021/1/6 11:27
 * @Description:
 */
public class StackTest {

    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        stackTest.methodA();
    }

    public void methodA(){
        int i=10;
        int j=20;

        methodB();
    }

    public void methodB(){
        int k = 30;
        int m = 40;
    }
}
