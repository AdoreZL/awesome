package com.zl.awesome.queue;

/**
 * @author: netposa
 * @Date: 2021/4/7 15:14
 * @Description: 基于数组实现一个简单队列，用数组实现queue
 */
public class MyArrayQueue {
    //声明一个数组，int或者integer都行，这里用Integer是因为不想看到int的默认值为0
    private Integer[] arr;
    //声明一个变量index来记录当前下标
    private int index = 0;

    public MyArrayQueue(Integer size) {
        //实例化数组时的容量
        this.arr=new Integer[size];
    }

    public MyArrayQueue() {
        //没有指定容量的话默认为5
        this.arr=new Integer[5];
    }

    //放入元素
    public void add(int p){
        arr[index++]=p;
    }

    //取出头部元素
    public int get(){
        return arr[0];
    }

    //取出头部元素并删除
    public int getAndRemove(){
        int res = this.arr[0];
        //将数组元素往前平移
        for (int i = 1; i <this.arr.length; i++) {
            arr[i-1] = arr[i];
        }
        //下标-1
        index--;
        return res;
    }

    //打印当前数组
    public void swithArr(){
        for (Integer integer : this.arr) {
            System.out.println(integer + " ");
        }
    }
}


class Test{
    public static void main(String[] args) {
        MyArrayQueue queue = new MyArrayQueue(8);
        queue.add(1);
        queue.add(3);
        queue.add(5);
        queue.add(7);
        queue.add(9);
        //取出头部元素并删除，应该返回1
        System.out.println(queue.getAndRemove());
        System.out.println(queue.get());
        queue.swithArr();
    }
}