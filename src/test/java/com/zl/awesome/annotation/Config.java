package com.zl.awesome.annotation;

import com.zl.awesome.annotation.resouce.Y;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author: netposa
 * @Date: 2021/1/22 10:44
 * @Description:
 */
@Configuration
@ComponentScan(basePackages = {"com.zl.awesome.annotation"})
public class Config {
    @Bean
    public Student student1(){
        Student student = new Student();
        student.setNum("2");
        return student;
    }

    @Primary   //标有Primary注解，使用@Autowired和@Inject注解注解时，优先被加载
    @Bean
    public Y y1(){
        Y y = new Y();
        y.setI(3);
        return y;
    }

}
