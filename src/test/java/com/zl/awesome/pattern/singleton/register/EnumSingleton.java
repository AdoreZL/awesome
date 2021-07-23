package com.zl.awesome.pattern.singleton.register;

/**
 * @author: netposa
 * @Date: 2020/11/30 17:08
 * @Description:
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
