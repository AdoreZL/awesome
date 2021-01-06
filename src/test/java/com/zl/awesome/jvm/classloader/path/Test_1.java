package com.zl.awesome.jvm.classloader.path;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @author: netposa
 * @Date: 2021/1/4 11:11
 * @Description:
 */
public class Test_1 {
    public static void main(String[] args) {
        String[] urls = System.getProperty("sun.boot.class.path").split(":");

        for (String url:urls
             ) {
            System.out.println(url);
        }
        System.out.println("=======================================");

        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url:urLs
             ) {
            System.out.println(url);
        }
    }
}
