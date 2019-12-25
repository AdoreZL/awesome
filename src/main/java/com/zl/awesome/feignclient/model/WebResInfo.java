package com.zl.awesome.feignclient.model;

import lombok.Data;

@Data
public class WebResInfo {
    /**
     * 响应码
     */
    private String code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应结果即数据
     */
    private Object data;
}
