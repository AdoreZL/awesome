package com.zl.awesome.annotation;

import org.springframework.stereotype.Component;

/**
 * @author: netposa
 * @Date: 2021/1/22 10:41
 * @Description:
 */
@Component
public class Student {
    private String num ="1";

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
