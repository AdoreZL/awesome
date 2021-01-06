package com.zl.awesome.jvm;

import java.util.UUID;

/**
 * @author: netposa
 * @Date: 2021/1/4 09:09
 * @Description:  UUID动态加载会加载Test_7_A。
 */
public class Test_7 {
    public static void main(String[] args) {
        System.out.println(Test_7_A.uuid);
    }
}
    class Test_7_A{
        public static final String uuid = UUID.randomUUID().toString();
        static {
            System.out.println("Test_7_A Static Block");
        }
    }
