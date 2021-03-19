package com.zl.awesome.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: netposa
 * @Date: 2021/3/18 11:28
 * @Description:
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //CyclicBarrier(int parties,Runnable barrierAction)
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() ->{
            System.out.println("***召唤神龙");
        });
        for (int i = 0; i <7; i++) {
            final int tempInt = i;
            new Thread(() ->{ System.out.println(Thread.currentThread().getName()+"\t"+tempInt+"滴滴");
            try {
                cyclicBarrier.await();
            }catch (InterruptedException | BrokenBarrierException e){
                e.printStackTrace();
            }
            },String.valueOf(i)).start();
        }
    }
}
