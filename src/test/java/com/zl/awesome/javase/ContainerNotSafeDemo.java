package com.zl.awesome.javase;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: netposa
 * @Date: 2021/3/17 11:30
 * @Description: 集合不安全的相关问题
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a","b","c");
//        list.forEach(System.out::println);
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i <=30 ; i++) {
            new Thread(() ->{
             list.add(UUID.randomUUID().toString().substring(0,8));
             System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
