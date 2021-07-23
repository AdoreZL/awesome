package com.zl.awesome.pattern.singleton.seriable;

/**
 * @author: netposa
 * @Date: 2020/11/30 16:35
 * @Description:
 */
public class SeriableSingleton {

    public final static SeriableSingleton  INSTANCE= new SeriableSingleton();

    private SeriableSingleton(){};

    public static SeriableSingleton getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}
