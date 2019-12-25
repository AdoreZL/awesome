package com.zl.awesome.util;

import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileUtil {
    public static Map<String, String> getProperties(String fileName) {
        Properties props = new Properties();
        Map<String, String> map = new HashMap<>();
        try {
            props.load(new InputStreamReader(FileUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8"));
            Enumeration en = props.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String property = props.getProperty(key);
                map.put(key, property);
                System.out.println(key + "=" + property);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String args[]) {
        Map<String, String> map = new FileUtil().getProperties("static/jsfw.properties");
        System.out.println("11111");
    }
}