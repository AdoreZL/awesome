package com.zl.awesome.thread;

/**
 * @author: netposa
 * @Date: 2021/5/12 16:38
 * @Description:
 */
public class AtomicDemo {
    private static int count=0;

    public synchronized static void incr(){
        try {
            Thread.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(AtomicDemo::incr).start();
        }
        Thread.sleep(5000);
        System.out.println("运行结果："+count);
    }
}
