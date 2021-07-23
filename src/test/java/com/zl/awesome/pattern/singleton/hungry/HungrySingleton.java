package com.zl.awesome.pattern.singleton.hungry;

/**
 * @author: netposa
 * @Date: 2020/11/30 11:15
 * @Description:
 */
public class HungrySingleton {

    private static final HungrySingleton HungrySingleton = new HungrySingleton();
    //构造函数私有化
    private HungrySingleton() {
    }

    public static  HungrySingleton getInstance(){
        return HungrySingleton;
    }
}
