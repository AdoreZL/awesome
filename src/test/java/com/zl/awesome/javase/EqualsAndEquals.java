package com.zl.awesome.javase;

/**
 * @author: netposa
 * @Date: 2021/3/23 14:54
 * @Description:
 */
public class EqualsAndEquals {
    public static void main(String[] args) {
        String s1 = new String("zs");
        String s2 = new String("zs");
        System.out.println(s1==s2);     //false
        String s3 = "zs";
        String s4 = "zs";
        System.out.println(s3==s4);     //true
        System.out.println(s3==s1);     //false  一个是常量池的地址，，一个是堆中的地址
        String s5 = "zszs";
        String s6 = s3+s4;
        System.out.println(s5==s6);      //false
        final String s7 = "zs";
        final String s8 = "zs";
        String s9 = s7+s8;
        System.out.println(s5 ==s9);      //true      常量
        final String s10=s3+s4;
        System.out.println(s5==s10);      //false     s3和s4依然是变量，会new出来
    }
}
