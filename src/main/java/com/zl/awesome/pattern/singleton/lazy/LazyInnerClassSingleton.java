package com.zl.awesome.pattern.singleton.lazy;

/**
 * @author: netposa
 * @Date: 2020/11/30 15:26
 * @Description:
 */
//全程没有用到synchronized
public class LazyInnerClassSingleton {
    private LazyInnerClassSingleton(){
        throw new RuntimeException("不允许构建多个实例");
    }
    //懒汉式单例
    //LazyHolder里面的逻辑需要等到外部方法调用才执行。
    //JVM底层执行逻辑，，完美地避开了线程安全问题
    public static final LazyInnerClassSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}