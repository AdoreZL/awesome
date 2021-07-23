package com.zl.awesome.noifelse;

import java.math.BigDecimal;

/**
 * @author: netposa
 * @Date: 2021/4/21 14:15
 * @Description: 专属会员
 */
public class ParticularlyVipPayService implements  UserPayService{
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
        if (orderPrice.compareTo(new BigDecimal(30)) > 0) {
            return orderPrice.multiply(new BigDecimal(0.7));
        }
        return null;
    }
}
