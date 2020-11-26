package com.zl.awesome.pattern.factory.simplefactory;

/**
 * @author: netposa
 * @Date: 2020/11/6 09:55
 * @Description:
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.create(JavaCourse.class);
        course.record();
    }
}
