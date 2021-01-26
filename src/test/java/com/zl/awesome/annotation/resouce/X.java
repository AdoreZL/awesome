package com.zl.awesome.annotation.resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: netposa
 * @Date: 2021/1/22 14:36
 * @Description:
 */
@Component
public class X {
    @Autowired
    private Y y2;

    public Y getY() {
        return y2;
    }

    public void setY(Y y) {
        this.y2 = y;
    }
}
