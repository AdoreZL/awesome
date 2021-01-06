package com.zl.awesome.pattern.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.InvocationHandler;
import java.util.StringJoiner;

/**
 * @author: netposa
 * @Date: 2020/12/4 11:18
 * @Description:
 */
public class GPProxy {

    public static final String ln ="\r\n";

//    public static Object newProxyInstance(GPClassLoader loader,
//                                          Class<?>[] interfaces,
//                                          GPInvocationHandler h){
//        try {
//            generateSrc(interfaces)
//        }catch (Exception e){
//
//        }
////            return null;
//    }

//    private static String generateSrc(Class<?>[] interfaces) {
//        //用代码写代码
////        StringBuffer sb = new StringBuffer();
//        StringJoiner sj = new StringJoiner(ln);
//        sj.add("package com.zl.awesome.pattern.proxy.dynamicproxy.gpproxy;");
//        sj.add("package com.zl.awesome.pattern.proxy.Person;");
//        sj.add("import java.lang.reflect.*;");
//        sj.add("public class $proxy0 implements"+interfaces[0].getName()+"{");
//        sj.add("GPInvocationHandler h;");
//        sj.add("public $proxy0(GPInvocationHandler h){");
//        sj.add("this.h=h"+"}");
//        sj.add("}");
//
//    }
}
