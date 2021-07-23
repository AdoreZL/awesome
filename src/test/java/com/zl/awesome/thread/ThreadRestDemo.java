package com.zl.awesome.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author: netposa
 * @Date: 2021/5/12 15:35
 * @Description: 线程复位的demo
 */
public class ThreadRestDemo {
    //1.Thread.interrupted()
    //2.InterruptedException
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->{
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("before:"+Thread.currentThread().isInterrupted());
                    //复位 -回到初始状态
                    Thread.interrupted();
                    System.out.println("after:"+Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        //把isInterrupted设置成true
        thread.interrupt();
    }
}