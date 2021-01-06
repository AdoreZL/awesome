package com.zl.awesome.javase;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: netposa
 * @Date: 2020/12/14 14:15
 * @Description:
 */
public class Serialization {
    @Test
    public void test() throws IOException, ClassNotFoundException {
        ArrayList<Student> list = new ArrayList<>(4);
        list.add(new Student("1",1));
        list.add(new Student("2",2));
        list.add(new Student("3",3));
        list.add(new Student("4",4));
        list.add(new Student("5",5));

        FileOutputStream fos = new FileOutputStream("D:\\foo");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(list);
        os.close();
        FileInputStream fin = new FileInputStream("D:\\foo");
        ObjectInputStream oi = new ObjectInputStream(fin);
        List<Student> o = (List<Student>) oi.readObject();
        oi.close();
        System.out.println(o.get(1).getName());
    }

    @AllArgsConstructor
    @Data
    public static class Student implements Serializable{
        private String name;
        private int age;
    }
}
