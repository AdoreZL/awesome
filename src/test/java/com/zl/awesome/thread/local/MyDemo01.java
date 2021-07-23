package com.zl.awesome.thread.local;

/**
 * @author: netposa
 * @Date: 2021/3/29 15:09
 * @Description:
 *   Threadlocal
 *   1.set方法：将变量绑定到当前线程中
 *   2.get方法：获取当前线程绑定的变量
 */
public class MyDemo01 {
    ThreadLocal<String> t1 = new ThreadLocal<>();
    //变量
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //    public String getContent() {
////        return content;
//        return t1.get();
//    }
//
//    public void setContent(String content) {
////        this.content = content;
//        //变量content绑定到当前线程
//        t1.set(content);
//    }

    public static void main(String[] args) {
        MyDemo01 demo = new MyDemo01();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                /*
                 *  每一个线程：存一个变量，过一会，取出这个变量。
                 */
                synchronized (MyDemo01.class){
                    demo.setContent(Thread.currentThread().getName()+"的数据");
                    System.out.println("---------------------");
                    System.out.println(Thread.currentThread().getName()+"---->"+demo.getContent());
                }
            });
            thread.setName("线程"+i);
            thread.start();
        }
    }
}
