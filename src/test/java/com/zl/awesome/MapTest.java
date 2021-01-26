package com.zl.awesome;

import java.lang.reflect.Field;

/**
 * @author: netposa
 * @Date: 2021/1/25 20:15
 * @Description:
 */
public class MapTest {
    private String name;

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {

        MapTest m = new MapTest();
        setField(m, "name", "321");
        System.out.println(m.getName());
    }

    public static void setField(Object o, String methodName, Object para)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Class<?> clazz = o.getClass();
        Field field = clazz.getDeclaredField(methodName);
        field.setAccessible(true);
        field.set(o, para);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
