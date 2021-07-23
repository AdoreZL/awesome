package com.zl.awesome.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: netposa
 * @Date: 2021/6/23 11:39
 * @Description:
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue. offer("string"); // add
        System. out. println(queue. poll());
        System. out. println(queue. remove());
        System. out. println(queue. size());

    }
}
