package com.zl.awesome.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: netposa
 * @Date: 2021/4/7 16:16
 * @Description:
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("123","456");
        map.put("1","456");
        map.put("2","456");
        map.put("3","456");
        map.put("5","789");
        //遍历entry，从entry中拿key和value
        map.forEach((key, value) -> {
            System.out.print(key + "：");
            System.out.println(value);
        });
        //单独遍历key和value
        map.keySet().forEach(System.out::println);
        map.values().forEach(System.out::println);
        //使用Iterator
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            System.out.println(entry.getValue());
        }
        //用key找value
        map.keySet().forEach(key->{
            System.out.println(key+": ");
            System.out.println(map.get(key));
        });
    }
}
