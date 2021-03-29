package com.zl.awesome.thread;

/**
 * @author: netposa
 * @Date: 2021/3/26 15:15
 * @Description:
 */
public class JoinMethod {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                    Thread.sleep(500);
            }catch (InterruptedException e){
                    e.printStackTrace();
            }
            System.out.println("222222");
        });
        t1.start();
        t1.join();
        System.out.println("1111");
    }
}
