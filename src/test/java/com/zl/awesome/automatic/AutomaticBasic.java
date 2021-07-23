package com.zl.awesome.automatic;

/**
 * @author: netposa
 * @Date: 2021/5/18 20:22
 * @Description: 基本数据类型的自动拆箱，装箱过程
 */
public class AutomaticBasic {
    public static void main(String[] args) {
        Integer i1= new Integer(12);
        Integer i2= new Integer(12);
        System.out.println(i1==i2);  //false

        Integer i3 = 126;
        Integer i4 = 126;
        int i5 = 126;
        System.out.println(i3==i4);   //true
        System.out.println(i3==i5);    //true

        Integer i6 =128;
        Integer i7 =128;
        int i8 = 128;
        System.out.println(i6==i7);   //false
        System.out.println(i6==i8);   //true
    }

}
