package com.zl.awesome.algorithm;

import javax.xml.bind.ValidationException;

/**
 * @author: netposa
 * @Date: 2021/5/18 20:09
 * @Description:  规规 N!=(n-1)*n；
 *        出口：n==1或n==0 return 1;
 */
public class Stratum {
    public static void main(String[] args) throws ValidationException {
        System.out.println(getResult(6));
    }

    public static int getResult(int n) throws ValidationException {
        if(n<0){
            throw new ValidationException("非法参数");
        }
        if(n==0||n==1){
            return 1;
        }
        return getResult(n-1)*n;
    }
}
