package com.zl.awesome.algorithm;

/**
 * @author: netposa
 * @Date: 2021/4/7 14:15
 * @Description:  快速排序小demo
 */
public class QuickSort {
    public static int[] sort(int[] arr, int left, int right) {
        //left和right为数组边界的下标，如果left >= right，则直接返回，无需排序
        if (left >= right) return arr;

        //定义两个游标i和j，我们将通过i和j确定出参照数的下标
        //注意将i、j与left、right区分，i、j是游标，而left、right是扫描边界，边界是进入方法后确定不变的，而i和j会一直变化
        int i = left, j = right, temp = arr[left];

        //开始从两端往中间扫描，确认参照数下标，所有操作都是基于i<j
        while (i < j) {
            //先从右往左扫描
            //如果j处的元素大于参照数，则j-1，继续往数组中部扫描
            while (arr[j] >= temp && i < j) j--;
            //如果j处的元素小于参照数，则将j处的元素赋值给i处，这里的if判断其实可以不写，写出来只是为了方便大家理解
            if (arr[j] < temp && i < j) arr[i] = arr[j];

            //再从左往右扫描
            //如果i处的元素小于参照数，则i+1，继续往数组中部扫描
            while (arr[i] <= temp && i < j) i++;
            //如果i处的元素大于参照数，则将i处的元素赋值给j处，这里的if判断其实可以不写，写出来只是为了方便大家理解
            if (arr[i] > temp && i < j) arr[j] = arr[i];
            //记住我们扫描的目的===> 为了找出参照数在数组中正确的下标，这个下标左边的元素都比参照数小，右边的都比它大
            //记住我们扫描的目的===> 为了找出参照数在数组中正确的下标，这个下标左边的元素都比参照数小，右边的都比它大
            //记住我们扫描的目的===> 为了找出参照数在数组中正确的下标，这个下标左边的元素都比参照数小，右边的都比它大
        }
        //这里也可以换成arr[j] = temp，因为经过扫描后，i==j
        arr[i] = temp;
        //这是快速排序的精髓所在，分治递归，将数组分成两半，前半部分是0到i-1
        sort(arr, left, i - 1);
        //后半部分是i+1到数组长度-1
        sort(arr, i + 1, right);
        return arr;
    }

    public static void main(String[] args) {
        //定义一个无序数组
        int[] arr = {5, 12, 3, 18, 19, 55, 0, 28, -1, 33};
        System.out.print("原数组：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        //left和right代表数组两端边界的下标
        sort(arr, 0, arr.length - 1);
        System.out.print("\n排序后：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}