package com.zl.awesome.pattern.prototype.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: netposa
 * @Date: 2020/12/3 11:46
 * @Description:
 */
public class PrototypeTest {
    public static void main(String[] args) {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(18);
        concretePrototypeA.setName("zl");
        List hobbies = new ArrayList<String>();
        hobbies.add("体育");
        concretePrototypeA.setHobbies(hobbies);

        Client client = new Client();
        ConcretePrototypeA copy = (ConcretePrototypeA) client.startClone(concretePrototypeA);
        System.out.println(copy);

        System.out.println("克隆对象中引用类型地址的值："+ copy.getHobbies());
        System.out.println("原对象的引用类型地址的值："+ concretePrototypeA.getHobbies());
        System.out.println("对象地址比较："+(copy.getHobbies()==concretePrototypeA.getHobbies()));
    }
}
