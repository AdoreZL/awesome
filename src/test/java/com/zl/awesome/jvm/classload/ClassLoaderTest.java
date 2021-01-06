package com.zl.awesome.jvm.classload;

/**
 * @author: netposa
 * @Date: 2021/1/5 15:42
 * @Description:
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        //获取再上层:获取不到引导类加载器
        ClassLoader bootstrap = extClassLoader.getParent();
        System.out.println(bootstrap);

        //对于自定义类获取当前类的类加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //String类使用引导类加载器进行加载   ----> java的核心类库都是通过引导类加载器进行加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
