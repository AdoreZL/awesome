package com.zl.awesome.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: netposa
 * @Date: 2021/3/22 15:37
 * @Description:
 */
public class SaturationPolicy {
    public static void policy(RejectedExecutionHandler handler){
        ThreadPoolExecutor exec = new ThreadPoolExecutor(2,3,0l, TimeUnit.MICROSECONDS,new LinkedBlockingDeque<>(5));
        if(handler!=null){
            //设置饱和策略
            exec.setRejectedExecutionHandler(handler);
        }
        for (int i = 0; i < 10; i++) {
            exec.submit(new Task());
        }
        exec.shutdown();
    }
    public static void main(String[] args) {

//        policy(new ThreadPoolExecutor.AbortPolicy());
        policy((new ThreadPoolExecutor.CallerRunsPolicy()));
//        policy(new ThreadPoolExecutor.DiscardPolicy());
//        policy(new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    //自定义任务
    static class Task implements Runnable{
        private static int count = 0;
        private int id =0;

        public Task() {
            id=++count;
        }

        @Override
        public void run() {
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(" 任务：" + id + "\t 工作线程: "+ Thread.currentThread().getName() + " 执行完毕");
        }
    }
}


