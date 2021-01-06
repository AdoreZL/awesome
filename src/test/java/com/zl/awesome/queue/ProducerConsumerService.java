package com.zl.awesome.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @author: netposa
 * @Date: 2020/12/28 18:58
 * @Description: 生产者，消费者
 */
public class ProducerConsumerService {
    public static void main(String[] args) {
        //创建大小为10的BlockingQueue
        BlockingQueue<Mantou> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        // 开启 producer线程向队列中生产消息
        new Thread(producer).start();
        // 开启 consumer线程 中队列中消费消息
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
    }
}
