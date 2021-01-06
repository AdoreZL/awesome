package com.zl.awesome.pattern.proxy.staticproxy;

import com.zl.awesome.pattern.proxy.dbroute.proxy.IOrderService;
import com.zl.awesome.pattern.proxy.dbroute.proxy.Order;
import com.zl.awesome.pattern.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: netposa
 * @Date: 2020/12/3 17:29
 * @Description:
 */
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;
    public OrderServiceStaticProxy(IOrderService orderService){
        this.orderService=orderService;
    }

    @Override
    public int createOrder(Order order) {
        Long createTime = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(simpleDateFormat.format(new Date(createTime)));
        System.out.println("静态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);
        this.orderService.createOrder(order);
        //重置相关
        DynamicDataSourceEntity.restore();
        return 0;
    }
}
