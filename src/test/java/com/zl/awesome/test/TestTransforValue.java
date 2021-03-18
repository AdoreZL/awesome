package com.zl.awesome.test;

/**
 * @author: netposa
 * @Date: 2021/3/17 15:15
 * @Description:
 */
public class TestTransforValue {
    public void changeValue1(int age){
        age=30;
    }
    public void changeValue2(Person person){
        person.setPersonName("磊磊");
    }
    public void changeValue3(String str){
        str="xxx";
    }

    public static void main(String[] args) {
        TestTransforValue test = new TestTransforValue();
        int age =20;
        test.changeValue1(age);
        System.out.println("age----"+age);

        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("personName---"+person.getPersonName());

        String str ="abc";
        test.changeValue3(str);
        System.out.println("String---"+str);
    }
}
