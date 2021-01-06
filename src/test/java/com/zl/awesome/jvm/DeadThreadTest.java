package com.zl.awesome.jvm;

/**
 * @author: netposa
 * @Date: 2021/1/5 11:24
 * @Description:
 */
public class DeadThreadTest {
    public static void main(String[] args) {
        Runnable r =() ->{
            System.out.println(Thread.currentThread().getName()+"开始");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName()+"结束");
        };

        Thread t1 = new Thread(r, "线程1");
        Thread t2 = new Thread(r, "线程2");

        t1.start();
        t2.start();
    }
}

class DeadThread{
    static{
        if(true){
            System.out.println(Thread.currentThread().getName()+"初始化当前类");
            while (true){

            }
        }
    }
}
