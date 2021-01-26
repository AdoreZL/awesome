package com.zl.awesome.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: netposa
 * @Date: 2021/1/22 10:55
 * @Description:
 */
@Component
public class Teacher {
    @Autowired
    private Map<String,Student> student;
    public Map<String, Student> getStudent() {
        return student;
    }

    public void setStudent(Map<String, Student> student) {
        this.student = student;
    }


}
