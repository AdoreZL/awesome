package com.zl.awesome.javase;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: netposa
 * @Date: 2020/12/21 11:27
 * @Description:
 */
public class LinkedListTest {
    public static void main(String[] args) {
        int length = 10000;
        LinkedList ll = new LinkedList();

        for (int i = 0; i < length; i++) {
            ll.add(i);
        }

        long start5 = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            ll.get(i); //随机访问   每次都要遍历
        }
        long end5 = System.currentTimeMillis();
        System.out.println(end5-start5);

        long start6 = System.currentTimeMillis();
        Iterator it = ll.listIterator(4);
        while (it.hasNext()){
            it.next();
            //会触发fastfail，，
            ll.remove(2);
        }
        long end6 = System.currentTimeMillis();
        System.out.println(end6-start6);
    }
}
