package com.zl.awesome.juc.volatiled;

/**
 * @author: netposa
 * @Date: 2020/12/30 17:59
 * @Description:
 */
public class VisibilityTest {
    private volatile boolean  flag = true;

    public void refresh(){
        flag = false;
        System.out.println(Thread.currentThread().getName()+"修改flag");
    }

    public void load(){
        System.out.println(Thread.currentThread().getName()+"开始执行.....");
        int i = 0;
        while(flag){
            i++;
        }
        System.out.println(Thread.currentThread().getName()+"跳出循环: i="+ i);
    }

    public static void main(String[] args){
        VisibilityTest test = new VisibilityTest();
        new Thread(() -> test.load(), "threadA").start();
        try {
            Thread.sleep(2000);
            new Thread(()->test.refresh(),"threadB").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }
}
