package com.zl.awesome.javase.target;

/**
 * @author: netposa
 * @Date: 2021/4/17 22:55
 * @Description:
 */
public class TargetObject {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
