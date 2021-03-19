package com.zl.awesome.queue.study;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: netposa
 * @Date: 2021/3/18 19:09
 * @Description: 一个初始值为零的变量，两个线程对其操作，一个加1，一个减1，来5轮
 * 1.线程操作资源类
 * 2.判断干活通知
 * 3.防止虚假唤醒
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
            new Thread(() ->{
                for (int i = 1; i <7; i++) {
                    try {
                        shareData.incremet();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"AAA").start();

        new Thread(() ->{
            for (int i = 1; i <7; i++) {
                try {
                    shareData.decremet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();
    }
}

//资源类
class ShareData{
    private int number=0;
    private Lock lock =  new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void incremet() throws Exception{
        lock.lock();
        try{
            //1 判断
            while (number!=0){
                //等待，不能生产
                condition.await();}
            //干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3.通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decremet() throws Exception{
        lock.lock();
        try{
            //1 判断
            while (number==0){
                //等待，不能删除
                condition.await();}
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3.通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}