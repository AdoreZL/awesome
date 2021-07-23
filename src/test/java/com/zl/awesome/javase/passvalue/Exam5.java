package com.zl.awesome.javase.passvalue;

/**
 * @author: netposa
 * @Date: 2021/6/9 10:05
 * @Description: 成员变量于局部变量
 */
public class Exam5 {
    static int s;     //成员变量   类变量
    int j;            //成员变量   实例变量
    int i;            //成员变量
    {
        int i = 1;     //非静态代码块的局部变量
        i++;
        j++;
        s++;
    }
    public void test(int j){
        i++;
        j++;
        s++;
    }

    public static void main(String[] args) {
        Exam5 obj1 = new Exam5();
        Exam5 obj2 = new Exam5();
        obj1.test(10);
        obj1.test(20);
        obj2.test(30);
        System.out.println(obj1.i+","+obj1.j+","+Exam5.s);
        System.out.println(obj2.i+","+obj2.j+","+Exam5.s);
    }
}
