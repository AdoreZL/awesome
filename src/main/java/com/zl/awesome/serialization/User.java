package com.zl.awesome.serialization;

import java.io.Serializable;

/**
 * @author: netposa
 * @Date: 2020/12/6 15:58
 * @Description:
 */
public class User implements Serializable {
    private static final long serialVersionUID = -5263550034121832802L;

    private  String name;
    private  int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
