package com.zl.awesome.pattern.singleton.test;

import com.zl.awesome.pattern.singleton.lazy.LazyDoubleCheckSingleton;

/**
 * @author: netposa
 * @Date: 2020/11/30 11:34
 * @Description:
 */
public class ExectorThread implements Runnable{
    @Override
    public void run() {
        LazyDoubleCheckSingleton singleton = LazyDoubleCheckSingleton.getInstance();
//        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+":"+singleton);
    }
}
