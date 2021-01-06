package com.zl.awesome.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author: netposa
 * @Date: 2020/12/28 18:19
 * @Description: 使用BlockingQueue来解决生产者，消费者的问题
 */
public class Consumer implements  Runnable{

    BlockingQueue<Mantou> queue;

    public Consumer(BlockingQueue<Mantou> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Mantou mantou;
            while (!(mantou =queue.take()).getMantou().equals("exit")){
                Thread.sleep(100);
                System.out.println("消费馒头： " + mantou.getMantou());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
