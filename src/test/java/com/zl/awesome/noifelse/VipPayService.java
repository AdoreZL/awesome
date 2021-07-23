package com.zl.awesome.noifelse;

import java.math.BigDecimal;

/**
 * @author: netposa
 * @Date: 2021/4/21 14:18
 * @Description:
 */
public class VipPayService implements UserPayService{
    @Override
    public BigDecimal quote(BigDecimal orderPrice) {
//        if(该用户超级会员刚过期并且尚未使用过临时折扣){
//            临时折扣使用次数更新();
//            returen 8折价格;
//        }
//        return 9折价格;
        return null;
    }
}
