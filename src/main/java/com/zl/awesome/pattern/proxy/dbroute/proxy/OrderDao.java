package com.zl.awesome.pattern.proxy.dbroute.proxy;

/**
 * @author: netposa
 * @Date: 2020/12/3 17:12
 * @Description:
 */
public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao创建Order成功");
        return 1;
    }
}
