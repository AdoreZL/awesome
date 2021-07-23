package com.zl.awesome.noifelse;

import java.math.BigDecimal;

/**
 * @author: netposa
 * @Date: 2021/4/21 14:12
 * @Description: 1.外卖平台上的某家店铺为了促销，设置了多种会员优惠，其中包含超级会员折扣8折、普通会员折扣9折和普通用户没有折扣三种。
 * 2. 希望用户在付款的时候，根据用户的会员等级，就可以知道用户符合哪种折扣策略，进而进行打折，计算出应付金额。
 * 3. 随着业务发展，新的需求要求专属会员要在店铺下单金额大于30元的时候才可以享受优惠。
 * 4. 接着，又有一个变态的需求，如果用户的超级会员已经到期了，并且到期时间在一周内，那么就对用户的单笔订单按照超级会员进行折扣，并在收银台进行强提醒，引导用户再次开通会员，而且折扣只进行一次。
 */
public interface UserPayService {
    /**
     *
     * @param orderPrice
     * @return 计算应付的价格
      */
    public BigDecimal quote(BigDecimal orderPrice);
}
