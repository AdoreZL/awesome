package com.zl.awesome.algorithm;

import javax.xml.bind.ValidationException;

/**
 * @author: netposa
 * @Date: 2021/3/23 16:29
 * @Description:  求N的阶乘
 * 1,1,2,3,5,8,13,21,34 ...
 */
public class RecursionDemo {
    public static void main(String[] args) throws ValidationException {
        System.out.println(getResult(6));
    }

    private static int getResult(int n) throws ValidationException {
        if(n<0){
            throw new ValidationException("非法参数");
        }
        if(n==1||n==0){
            return 1;
        }
        return getResult(n-1)+getResult(n-2);
    }
}
