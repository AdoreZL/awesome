package com.zl.awesome.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: netposa
 * @Date: 2021/5/13 15:31
 * @Description:
 */
public class ConditionNotify implements Runnable{
    private Lock lock;
    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            //竞争锁，
            lock.lock();
            System.out.println("begin - conditionNotify");
            //唤醒阻塞状态的线程
            condition.signal();
            System.out.println("end - conditionNotify");
        }finally {
            //释放锁
            lock.unlock();
        }
    }
}
