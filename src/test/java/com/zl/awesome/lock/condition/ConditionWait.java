package com.zl.awesome.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: netposa
 * @Date: 2021/5/13 15:31
 * @Description:
 */
public class ConditionWait implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            //竞争锁，
            lock.lock();
            try {
                //阻塞
                System.out.println("begin - ConditionWait");
                condition.await();
                System.out.println("end - ConditionWait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            //释放锁
            lock.unlock();
        }
    }
}
