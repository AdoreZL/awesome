package com.zl.awesome.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: netposa
 * @Date: 2021/4/21 11:03
 * @Description: 多线程环境不使用原子类保证线程安全（基本数据类型）
 */
public class SyncInteger {
    private volatile int count =0;
    //若要线程安全执行count操作，，需要加锁
    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}

class Test2{
    private AtomicInteger count = new AtomicInteger();
    public void increment(){
        count.incrementAndGet();
    }
    //使用AtomicInteger之后，不需要加锁，也可以实现线程安全。
    public int getCount(){
        return count.get();
    }
}
