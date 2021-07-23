package com.zl.awesome.noifelse;

import java.math.BigDecimal;

/**
 * @author: netposa
 * @Date: 2021/4/21 14:17
 * @Description:
 */
public class SuperVipPayService implements  UserPayService{
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        return orderPrice.multiply(new BigDecimal(0.8));
    }
}
