package com.zl.awesome.annotation.autoprimay;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author: netposa
 * @Date: 2021/1/22 11:25
 * @Description:
 */
@Service("operaSinger")
public class OperaSinger implements Singer{
    @Override
    public String sing(String lyrics) {
        return "I am singing in Bocelli voice: "+lyrics;
    }
}
