package com.zl.awesome.jvm.classload;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @author: netposa
 * @Date: 2021/1/5 16:21
 * @Description:
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("**********启动类加载器***********");
        //获取BootstrapClassLoader能够加载的api的路径，，都是引导类加载器
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL element:urLs
             ) {
            System.out.println(element.toExternalForm());
        }
        //从上面的路径中随意选择一个类，来看看他的类加载器是什么，，扩展类加载器

        System.out.println("**********扩展类加载器***********");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path: extDirs.split(";")
             ) {
            System.out.println(path);
        }
    }
}
