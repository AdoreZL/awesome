package com.zl.awesome.lock;


import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有:"+lockA+"\t 尝试获得："+lockB);
            //暂停一会
            try { TimeUnit.SECONDS.sleep(2); }catch (InterruptedException e){ e.printStackTrace();}
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有:"+lockB+"\t 尝试获得："+lockA);
            }
        }
    }
}
/**
 * @author: netposa
 * @Date: 2021/3/22 19:16
 * @Description:
 *  死锁是指两个或者两个以上的进程在执行过程中，因争夺资源而造成一种互相等待的现象，若无外力干涉那它们都无法推进下去。
 */
public class DeadLockDemo {
    public static void main(String[] args) {
            String lockA = "lockA";
            String lockB = "lockB";
            new Thread(() -> new HoldLockThread(lockA,lockB),"ThreadAAA").start();
            try { TimeUnit.SECONDS.sleep(2); }catch (InterruptedException e){ e.printStackTrace();}
            new Thread(() -> new HoldLockThread(lockB,lockA),"ThreadBBB").start();
    }
}
