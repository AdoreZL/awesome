package com.zl.awesome.pattern.proxy.dbroute.proxy;


import com.zl.awesome.pattern.proxy.staticproxy.OrderServiceStaticProxy;

import java.util.Date;

/**
 * @author: netposa
 * @Date: 2020/12/4 09:55
 * @Description:
 */
public class DbRouteProxyTest {
    public static void main(String[] args) {
        Order order = new Order();
        order.setCreateTime(System.currentTimeMillis());
        IOrderService orderService=new OrderServiceStaticProxy(new OrderService());
        orderService.createOrder(order);
    }
}
