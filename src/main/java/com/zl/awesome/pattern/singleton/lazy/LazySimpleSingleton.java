package com.zl.awesome.pattern.singleton.lazy;

/**
 * @author: netposa
 * @Date: 2020/11/30 11:25
 * @Description:
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton lazy = null;
    /**
     *     //首先构造方法私有化
     */
    private LazySimpleSingleton(){}

    public synchronized static LazySimpleSingleton getInstance(){
        if(null==lazy){
            lazy = new LazySimpleSingleton();
            return lazy;
        }
        return lazy;
    }

}
