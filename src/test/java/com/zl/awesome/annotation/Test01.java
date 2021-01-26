package com.zl.awesome.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: netposa
 * @Date: 2021/1/22 10:58
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        Teacher teacher = context.getBean(Teacher.class);
//        System.out.println(teacher.getStudent());
    }
}
