package com.zl.awesome.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 资源类
 * 如果使用ReentrantLock或者sync会阻塞，，，不允许其他线程进来，不符合高并发的特性
 */
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
//    private Lock lock = new ReentrantLock();
    final private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
        //暂停一会线程
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入："+key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成：");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key){
        rwLock.readLock().lock();
        //暂停一会线程
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取：");
            TimeUnit.MILLISECONDS.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成："+result);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }

    /**
     * 删除缓存
     */
    public void clearMap(){
        map.clear();
    }
}
/**
 * @author: netposa
 * @Date: 2021/3/18 08:38
 * @Description:
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行
 * 但是如果有一个线程想去写共享资源来，就不该再有其他线程可以对该资源进行读或写
 * 小总结：
 * 读-读能共存
 * 读-写不能共存
 * 写-写不能共存
 * 写操作：原子+独占
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i <=5; i++) {
            final int tempInt = i;
            new Thread(() -> myCache.put(tempInt+"",tempInt+""),String.valueOf(i)).start();
        }
        for (int i = 0; i <=5; i++) {
            final int tempInt = i;
            new Thread(() -> myCache.get(tempInt+""),String.valueOf(i)).start();
        }
    }
}