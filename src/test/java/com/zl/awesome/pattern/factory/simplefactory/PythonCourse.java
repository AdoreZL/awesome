package com.zl.awesome.pattern.factory.simplefactory;

/**
 * @author: netposa
 * @Date: 2020/11/6 17:45
 * @Description:
 */
public class PythonCourse implements ICourse{
    @Override
    public void record() {
        System.out.println("录制Python课程");
    }
}
