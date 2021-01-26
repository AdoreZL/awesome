package com.zl.awesome.copy;

import lombok.Data;

/**
 * @author: netposa
 * @Date: 2021/1/26 14:51
 * @Description:
 */
@Data
public class Student implements Cloneable{
    //引用类型
    private Subject subject;

    //基础数据类型
    private String name;

    private int age;

//    //浅拷贝
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }


    //深拷贝
    @Override
    public Object clone() {
//        return super.clone();
        try {
            //直接调用父类的clone()方法
            Student student = (Student) super.clone();
            student.subject = (Subject) subject.clone();
            return student;
        }catch (CloneNotSupportedException e){
            return null;
        }
    }

    @Override
    public String toString() {
        return "Student{" + this.hashCode()+
                "subject=" + subject +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
