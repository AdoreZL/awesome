package com.zl.awesome.algorithm;

import org.junit.Test;

/**
 * @author: netposa
 * @Date: 2021/6/9 09:44
 * @Description: 有n步台阶，一次只能上1步或2步，共有多少种走法
 */
public class RecursionTest {
        @Test
    public void test(){
            TestStep testStep = new TestStep();
            System.out.println(testStep.f(7));
        }
}

class TestStep{
    //实现f(n):求n步台阶，一共有几种走法
    public  int f(int n){
        if(n<1){
            throw new IllegalArgumentException(n+"不能小于1");
        }
        //当n=1或者n=2的时候比较特殊
        if(n==1||n==2){
            return n;
        }
        return f(n-2)+f(n-1);
    }
}