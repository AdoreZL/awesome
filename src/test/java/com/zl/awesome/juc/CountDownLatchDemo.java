package com.zl.awesome.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: netposa
 * @Date: 2021/3/18 10:27
 * @Description: 在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。秦想一统天下，需要灭六国
 *
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception{
        //CountDownLatch的数值必须要和循环的次数一致
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i <4; i++) {
//            final int tempInt = i;
            new Thread(() ->{ System.out.println(Thread.currentThread().getName()+"\t 上完自习，离开教室");
                countDownLatch.countDown();
                },String.valueOf(i)).start();
        }
        //此时线程位main的主线程需要等待循环中的线程走完,,,或者在时间流逝之内等待countDown线程
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t *********88班长最后关门走人");
    }
}
