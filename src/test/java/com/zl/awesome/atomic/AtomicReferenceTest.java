package com.zl.awesome.atomic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: netposa
 * @Date: 2021/4/21 11:14
 * @Description:  引用类型原子类，可以解决基本数据类型只能更新一个变量的问题，也可以解决CAS进行原子更新可能出现的ABA问题
 */
public class AtomicReferenceTest {
    public static void main(String[] args) {
        AtomicReference<Persons> ar = new AtomicReference<Persons>();
        Persons zl = new Persons("zl", 22);
        ar.set(zl);
        Persons updatePerson = new Persons("Daisy", 20);
        ar.compareAndSet(zl,updatePerson);

        System.out.println(ar.get().getName());
        System.out.println(ar.get().getAge());
    }
}

@Data
@AllArgsConstructor
class Persons{
    private String name;
    private int age;
}
