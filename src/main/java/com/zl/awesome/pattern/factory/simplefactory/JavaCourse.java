package com.zl.awesome.pattern.factory.simplefactory;

/**
 * @author: netposa
 * @Date: 2020/11/6 09:52
 * @Description:
 */
public class JavaCourse implements ICourse{
    @Override
    public void record() {
        System.out.println("录制Java课程");
    }
}
