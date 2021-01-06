package com.zl.awesome.pattern.singleton.lazy;

/**
 * @author: netposa
 * @Date: 2020/11/30 15:00
 * @Description:
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton() {
    }

    //类锁，，
    public  static LazyDoubleCheckSingleton getInstance(){
        if(null==lazyDoubleCheckSingleton){
            synchronized (LazyDoubleCheckSingleton.class) {
                if (null == lazyDoubleCheckSingleton) {
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
