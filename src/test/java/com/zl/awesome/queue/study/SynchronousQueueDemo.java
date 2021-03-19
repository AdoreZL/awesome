package com.zl.awesome.queue.study;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: netposa
 * @Date: 2021/3/18 17:45
 * @Description:   该队列不存储数据，生产一个就要消费。
 */
public class SynchronousQueueDemo {
    public static void main(String[] args){
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        //生产
            new Thread(() ->{
                try {
                    System.out.println(Thread.currentThread().getName()+"\t put 2");
                    blockingQueue.put("1");
                    System.out.println(Thread.currentThread().getName()+"\t put 2");
                    blockingQueue.put("2");
                    System.out.println(Thread.currentThread().getName()+"\t put 3");
                    blockingQueue.put("3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"AAA").start();


        //消费
        new Thread(() ->{
            try {
                try { TimeUnit.SECONDS.sleep(5); }catch (InterruptedException e){ e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
                try { TimeUnit.SECONDS.sleep(5); }catch (InterruptedException e){ e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
                try { TimeUnit.SECONDS.sleep(5); }catch (InterruptedException e){ e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
        }
}
