package com.zl.awesome.atomic;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: netposa
 * @Date: 2021/6/19 13:36
 * @Description: 如何解决ABA问题
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference= new AtomicReference<>( 100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        System.out.println("===========以下是ABA问题的产生===============");
        new Thread(() ->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();
        new Thread(() ->{
            //暂停1秒钟t2线程，保证上面的t1线程完成一次ABA操作
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                atomicReference.compareAndSet(100,101);
                atomicReference.compareAndSet(101,100);
            }
            System.out.println(atomicReference.compareAndSet(100,2021)+"\t"+atomicReference.get());
        },"t2").start();
        try{TimeUnit.SECONDS.sleep(2);}catch (InterruptedException e){}
        System.out.println("===========以下是ABA问题的解决===============");
        new Thread(() ->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号："+stamp);
            //暂停1秒钟t3线程
            try{TimeUnit.SECONDS.sleep(1);}catch (InterruptedException e){}
        },"t3").start();

        new Thread(() ->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号："+stamp);
            //暂停3秒钟t4线程，保证上面t3线程完成一次ABA操作
            try{TimeUnit.SECONDS.sleep(3);}catch (InterruptedException e){}
            boolean result = atomicStampedReference.compareAndSet(100, 2021, stamp, stamp + 1);
            int stamp1 = atomicStampedReference.getStamp();
            System.out.println(stamp1);
            System.out.println(Thread.currentThread().getName()+"\t修改成功否"+result);
        },"t4").start();
    }
}