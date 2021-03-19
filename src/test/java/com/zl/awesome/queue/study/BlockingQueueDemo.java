package com.zl.awesome.queue.study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: netposa
 * @Date: 2021/3/18 14:50
 * @Description:
 * ArrayBlockQueue:是一个基于数组结构的有界阻塞队列，此队列按照FIFO原则对元素进行排序。
 * LinkedBlockQueue:是一个基于链表结构的有界阻塞队列，此队列按照FIFO原则对元素进行排序，吞吐量通常要高于ArrayBlockQueue.
 * SynchronousQueue:一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直进入阻塞状态，吞吐量相对来说比较高。
 * 1.队列
 *
 * 2.阻塞队列
 *   2.1.阻塞队列有没有好的一面，
 *   2.2.不得不阻塞，如何管理。
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
//        List list = new ArrayList<>();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        //add 方法会抛出异常
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.add("x"));
    }
}
