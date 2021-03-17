package com.zl.awesome.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: netposa
 * @Date: 2021/3/17 10:33
 * @Description:
 */
public class LRUCacheDemo<K,V> extends LinkedHashMap<K,V> {
    //缓存坑位
    private int capacity;

    public LRUCacheDemo(int capacity) {
        this.capacity = capacity;
    }

    /**
     *  lru算法的判断条件，如果在capacity总量不变的情况下，加入元素的大小超过capacity，就删除最近最少被使用的
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size()>capacity;
    }


    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);
        lruCacheDemo.put(1,3);
        lruCacheDemo.put(2,3);
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,3);
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(4,3);
        System.out.println(lruCacheDemo.keySet());
    }
}
