package com.zl.awesome.queue;

import lombok.Data;

/**
 * @author: netposa
 * @Date: 2020/12/28 18:23
 * @Description: 普通Java对象，
 */
@Data
public class Mantou {
    public Mantou(String mantou) {
        this.mantou = mantou;
    }

    private String mantou;
}
