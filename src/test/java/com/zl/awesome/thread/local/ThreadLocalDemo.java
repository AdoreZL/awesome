package com.zl.awesome.thread.local;

/**
 * @author: netposa
 * @Date: 2021/3/29 09:48
 * @Description:
 */
public class ThreadLocalDemo {
    private static final ThreadLocal<Integer> TL_INT = ThreadLocal.withInitial(() -> 6);
    private static final ThreadLocal<String> TL_STRING = ThreadLocal.withInitial(() -> "Hello, world");

    public static void main(String[] args) {
        // 6
        System.out.println(TL_INT.get());   
        TL_INT.set(TL_INT.get()+1);
        // 7
        System.out.println(TL_INT.get());
        TL_INT.remove();
        // 会重新初始化该value，6
        System.out.println(TL_INT.get());
    }
}
