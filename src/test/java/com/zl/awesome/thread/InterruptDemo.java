package com.zl.awesome.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author: netposa
 * @Date: 2021/5/12 15:24
 * @Description: 线程中断的demo
 */
public class InterruptDemo {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->{
            while (!Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("i:"+i);
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        //把isInterrupted设置成true
        thread.interrupt();
    }
}
