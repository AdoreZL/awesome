package com.zl.awesome.thread;

import java.util.concurrent.*;

/**
 * @author: netposa
 * @Date: 2021/3/22 18:42
 * @Description:
 */
public class CustomsThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
                );
    }
}
