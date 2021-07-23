package com.zl.awesome.algorithm;

/**
 * @author: netposa
 * @Date: 2021/5/18 20:15
 * @Description: 如何实现递归求斐波那切数列第N个数字的值（传说中不死神兔就是这个问题）
 *  1.1.2.3.5.8.13.23.。。。
 */
public class StratumTwo {
    /*
    * 规律：每个数等于前两个数之和
    * 出口：第一项和第二项都等于1
    * */
    public static int getFeiBo(int n){
        if(n<0){
            return -1;
        }
        if(n==1||n==2){
            return 1;
        }else {
            return getFeiBo(n-1)+getFeiBo(n-2);
        }
    }

    public static void main(String[] args) {
//        getFeiBo(6);
        System.out.println(getFeiBo(7));
    }

}
