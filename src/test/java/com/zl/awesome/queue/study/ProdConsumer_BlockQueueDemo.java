package com.zl.awesome.queue.study;

import org.springframework.util.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//资源类
class MyResource{
    //默认开启，进行生产+消费
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue =null;

    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue=blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while (FLAG){
            data=atomicInteger.incrementAndGet()+"";
            //向队列中插入元素
            retValue=blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"生产完成");
    }

    //消费者
    public void myConsumer() throws Exception{
        String result = null;
        //当FLAG为true时消费queue里面的数据，
        while (FLAG){
            //消费元素
            result=blockingQueue.poll(2L,TimeUnit.SECONDS);
            //当消费不到元素的时候，通知消费者不消费了
            if(StringUtils.isEmpty(result)){
                FLAG=false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒钟没有取出蛋糕，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列蛋糕"+result+"成功");
        }
    }

    public void stop() throws Exception{
        this.FLAG=false;
    }
}
/**
 * @ author: netposa
 * @ Date: 2021/3/19 10:47
 * @ Description:   volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) throws Exception{
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(5));
        new Thread(() ->{
            System.out.println();
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();
        new Thread(() ->{
                try {
                    myResource.myConsumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        },"Consumer").start();

        try {
         TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("时间到了，，大老板main线程叫停，活动结束");
        myResource.stop();
    }
}
