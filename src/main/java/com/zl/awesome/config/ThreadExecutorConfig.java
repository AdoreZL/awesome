package com.zl.awesome.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: netposa
 * @Date: 2020/12/28 20:00
 * @Description: 线程池配置类
 */
public class ThreadExecutorConfig {
    /** 核心线程数 */
    @Value("20")
    private int corePoolSize;
    /** 最大线程数 */
    @Value("40")
    private int maxPoolSize;
    /** 队列数 */
    @Value("10")
    private int queueCapacity;

    private Executor getExecutor(String name) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(name);
        //饱和策略，不丢弃任何一个任务，但是会影响程序的整体性能
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
