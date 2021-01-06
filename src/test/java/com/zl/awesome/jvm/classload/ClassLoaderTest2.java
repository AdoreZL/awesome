package com.zl.awesome.jvm.classload;

/**
 * @author: netposa
 * @Date: 2021/1/5 16:53
 * @Description:
 */
public class ClassLoaderTest2 {
    public static void main(String[] args) {
        try {
            //1.
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);
            //2.
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(contextClassLoader);
            //3.
            ClassLoader parent = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(parent);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
