package com.zl.awesome.pattern.singleton.test;

/**
 * @author: netposa
 * @Date: 2021/6/23 18:18
 * @Description:
 */
public class Singleton {
    //静态变量保存唯一的实例
    private volatile static Singleton singleton;
    //构造函数私有化
    private Singleton(){
    }

    //获取唯一实例的方法
    public static Singleton getInstance(){
        if(null==singleton){
            synchronized (Singleton.class){
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
