package com.zl.awesome.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: netposa
 * @Date: 2021/3/18 14:14
 * @Description:
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //模拟一共3个停车位
        Semaphore semaphore = new Semaphore(3);
        //模拟6部汽车
        for (int i = 1; i <7; i++) {
            new Thread(() ->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t停3秒离开车位");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    //当车离开了之后需要恢复停车位
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
