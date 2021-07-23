package com.zl.awesome.threadlocal;

/**
 * @author: netposa
 * @Date: 2021/6/22 07:59
 * @Description:
 */
public class ThreadLocals {
    public static void main(String[] args) {
        ThreadLocal<PersonHeight> threadLocal = new ThreadLocal<>();
        PersonHeight personHeight = new PersonHeight(0);
        Thread t1 = new Thread(() -> {
            personHeight.setHeight(11);
            System.out.println(threadLocal.get().getHeight());
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            personHeight.setHeight(22);
            System.out.println(threadLocal.get().getHeight());
        });
        t2.start();
    }
}

class PersonHeight{
    float height;

    public PersonHeight(float height) {
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
