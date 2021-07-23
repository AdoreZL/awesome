package com.zl.awesome.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: netposa
 * @Date: 2021/5/14 16:54
 * @Description:
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);//线程数量固定为2，使用无限大的队列
        for(int i = 0; i < 10; i++) {
            try {
                executor.execute(new TestThread());
            } catch(Exception e) {
                e.printStackTrace();
            }

        }

        int threadCount = 0;
        while(true) {
            log.info("queuezzzzzzz"+((ThreadPoolExecutor)executor).getQueue().size());
            threadCount = ((ThreadPoolExecutor)executor).getActiveCount();
            log.info("threadCountzzzz"+threadCount);
            if(threadCount == 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i < 10; i++) {//写入10个线程到待执行队列中
            try {
                executor.execute(new TestThread());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        //上一段任务执行完毕，再次执行第二个任务。
        while(true) {
            log.info("queue2:"+((ThreadPoolExecutor)executor).getQueue().size());
            //log.info("taskcount2:"+((ThreadPoolExecutor)executor).getTaskCount());
            //注意，虽然上面executor.execute(new TestThread())写入了任务，但是getActiveCount也可能是0，因为当主线程走到这一步的时候，有可能线程还没有active
            threadCount = ((ThreadPoolExecutor)executor).getActiveCount();
            log.info("threadCount2:"+threadCount);
            if(threadCount == 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        log.info("--------------------");
    }
}

@Slf4j
class TestThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            log.info(this.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

