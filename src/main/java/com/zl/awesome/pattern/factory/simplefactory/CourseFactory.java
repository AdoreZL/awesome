package com.zl.awesome.pattern.factory.simplefactory;

import org.springframework.util.StringUtils;

/**
 * @author: netposa
 * @Date: 2020/11/6 11:42
 * @Description:
 */
public class CourseFactory {
//    public ICourse create(String factoryName){
//        if("java".equals(factoryName)){
//            return new JavaCourse();
//        }
//        return null;
//    }
        public ICourse create(Class clazz){
            try {
                if(null!=clazz){
                    return (ICourse)clazz.newInstance();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
}
