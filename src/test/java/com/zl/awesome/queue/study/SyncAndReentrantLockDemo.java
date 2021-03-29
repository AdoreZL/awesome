package com.zl.awesome.queue.study;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: netposa
 * @Date: 2021/3/19 10:08
 * @Description:
 * 题目：多线程之间按照顺序调用，实现A-B-C三个线程启动，要求如下：
 * A打印5次，B打印10次，C打印15次
 * 紧接着
 * A打印5次，B打印10次，C打印15次
 * 来10轮
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareDatas shareDatas = new ShareDatas();
        new Thread(() ->{
            for (int i = 1; i <10; i++) {
                try {
                    shareDatas.print5();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();
        new Thread(() ->{
            for (int i = 1; i <10; i++) {
                try {
                    shareDatas.print10();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();
        new Thread(() ->{
            for (int i = 1; i <10; i++) {
                try {
                    shareDatas.print15();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"CCC").start();
    }
}

class ShareDatas{
    //A为1，B为2，C为3
    private int number=1;
    //使用ReentrantLock
    private Lock lock =  new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public void print5() throws Exception{
        lock.lock();
        try{
            //1 判断
            while (number!=1){
                //等待，不能生产
                conditionA.await();}
            //干活
//            System.out.println(Thread.currentThread().getName()+"\t"+number);
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=2;
            //3.通知唤醒
//            conditionA.s;
            conditionB.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10() throws Exception{
        lock.lock();
        try{
            //1 判断
            while (number!=2){
                //等待，不能生产
                conditionB.await();}
            //干活
//            System.out.println(Thread.currentThread().getName()+"\t"+number);
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=3;
            //3.通知唤醒
//            conditionA.s;
            conditionC.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15() throws Exception{
        lock.lock();
        try{
            //1 判断
            while (number!=3){
                //等待，不能生产
                conditionC.await();}
            //干活
//            System.out.println(Thread.currentThread().getName()+"\t"+number);
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=1;
            //3.通知唤醒
//            conditionA.s;
            conditionA.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
