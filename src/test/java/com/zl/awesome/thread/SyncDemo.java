package com.zl.awesome.thread;

/**
 * @author: netposa
 * @Date: 2021/5/12 17:42
 * @Description:
 */
public class SyncDemo {
    public synchronized void demo(){

    }

    public void demo2(){
        synchronized (this){
            //保护存在线程安全的变量
        }
    }

    public void demo4(){
        synchronized (SyncDemo.class){

        }
    }

    public synchronized static void demo3(){

    }

    public static void main(String[] args) {

    }
}
