package com.zl.awesome.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: netposa
 * @Date: 2021/3/22 10:33
 * @Description: 获得/使用Java多线程的方式，线程池
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //一池，5个处理线程
//        ExecutorService  threadPool = Executors.newFixedThreadPool(5);
        //一池，N个线程
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //一池，1个线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //模拟10个用户来办理业务，每个用户都是一个来自外部的请求线程
        try {
            for (int i = 0; i < 20; i++) {
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName()+"\t 办理业务"));
                //暂停一会儿线程
                try{
                    TimeUnit.MILLISECONDS.sleep(200);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
