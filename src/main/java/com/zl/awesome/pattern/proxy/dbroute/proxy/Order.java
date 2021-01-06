package com.zl.awesome.pattern.proxy.dbroute.proxy;

import lombok.Data;

/**
 * @author: netposa
 * @Date: 2020/12/3 17:09
 * @Description:
 */
@Data
public class Order {
    private Object orderInfo;
    private Long createTime;
    private String id;
}
