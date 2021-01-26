package com.zl.awesome.annotation.autoprimay;

import org.springframework.stereotype.Service;

/**
 * @author: netposa
 * @Date: 2021/1/22 11:24
 * @Description:
 */
@Service("metalSinger")
public class MetalSinger implements Singer{
    @Override
    public String sing(String lyrics) {
        return "I am singing with DIO voice: "+lyrics;
    }
}
