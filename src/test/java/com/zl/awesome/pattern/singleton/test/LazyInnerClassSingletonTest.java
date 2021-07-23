package com.zl.awesome.pattern.singleton.test;

import com.zl.awesome.pattern.singleton.lazy.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;

/**
 * @author: netposa
 * @Date: 2020/11/30 15:37
 * @Description:
 */
public class LazyInnerClassSingletonTest {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = LazyInnerClassSingleton.class;
        Constructor<?> c = clazz.getDeclaredConstructor();
        c.setAccessible(true);
        Object o = c.newInstance();
        Object o2 = LazyInnerClassSingleton.getInstance();

        System.out.println(o == o2);
    }
}
