package com.zl.awesome.pattern.singleton.hungry;

/**
 * @author: netposa
 * @Date: 2020/11/30 11:20
 * @Description:
 */
public class HungryStaticSingleton {

    private static final HungryStaticSingleton hungryStaticSingleton;

    static {
        hungryStaticSingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){};

    public static HungryStaticSingleton getInstance(){
        return hungryStaticSingleton;
    }
}
