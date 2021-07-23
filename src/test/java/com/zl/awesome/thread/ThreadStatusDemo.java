package com.zl.awesome.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author: netposa
 * @Date: 2021/5/12 14:54
 * @Description: 线程的生命周期
 */
public class ThreadStatusDemo {
    public static void main(String[] args) {
          new Thread(() ->{
              while (true){
                  try {
                      TimeUnit.SECONDS.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          },"Time_Waiting_Thread").start();

          new Thread(() ->{
                while (true) {
                    synchronized (ThreadStatusDemo.class) {
                        try {
                            ThreadStatusDemo.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
          },"Waiting_Thread").start();

          new Thread(new BlockedDemo(),"Blocked01_Thread").start();
          new Thread(new BlockedDemo(),"Blocked02_Thread").start();
    }

    static class BlockedDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                while(true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}