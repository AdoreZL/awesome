package com.zl.awesome.pattern.abstactfactory;

/**
 * @author: netposa
 * @Date: 2020/11/10 11:59
 * @Description:
 */
public class AbstactFactoryTest {
    public static void main(String[] args) {
        ICourseFactory factory = new JavaCourseFactory();
        factory.createCourse().record();
        factory.createNote();
        factory.createVedio();
    }
}
