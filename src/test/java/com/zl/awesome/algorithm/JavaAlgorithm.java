package com.zl.awesome.algorithm;

import java.util.Arrays;

/**
 * @author: netposa
 * @Date: 2021/6/2 16:06
 * @Description:  java中一些常见的算法
 */
public class JavaAlgorithm {
    public static void main(String[] args) {
        //二分查找法
//        System.out.println(biSearch(new int[]{1, 2, 4, 5, 6, 66, 45, 157, 198, 323},323));
        //冒泡排序法
//        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 23, 1, 24, 777, 1024})));
        //插入排序算法
//        System.out.println(Arrays.toString(sort((new int[]{5, 23, 1, 24, 777, 1024}))));
        //快速排序算法
        
    }

    public static int biSearch(int []array,int a){
        int lo = 0;
        int hi = array.length-1;
        int mid;
        while (lo<=hi){
            //中间位置
            mid=(lo+hi)/2;
            if(array[mid]==a){
                return mid+1;
            }else if(array[mid]<a){
                //向右查找
                lo=mid+1;
            }else {
                //向左查找
                hi=mid-1;
            }
        }
        return -1;
    }

    public static int[] bubbleSort(int [] a){
        int i, j;
        //表示n次排序过程
        for (i = 0; i < a.length; i++) {
            for (j = 1; j < a.length-1; j++) {
                if(a[j-1]>a[j]){
            //前面的数字大于后面的数字就交换
            //交换a[j-1]和a[j]
                    int temp;
                    temp=a[j-1];
                    a[j-1]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }

    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
                    //插入的数
                int insertVal = arr[i];
                    //被插入的位置(准备和前一个数比较)
                int index = i-1;
                    //如果插入的数比被插入的数小
                while(index>=0&&insertVal<arr[index])
                {
                    //将把arr[index] 向后移动
                    arr[index+1]=arr[index];
                    //让index向前移动
                    index--;
                }
                    //把插入的数放入合适位置
                arr[index+1]=insertVal;
        }
        return arr;
    }
}
