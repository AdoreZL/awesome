package com.zl.awesome.util;

import javax.servlet.http.HttpServletRequest;

/**
  * web层工具类
  *
  */
public class WebKit {

    /**
      * 获取客户端的访问ip
      * @param request
      * @return
      */
    public static String getClientIp(HttpServletRequest request) {
        String nginxIp = request.getHeader("X-real-ip");
        if (StringKit.isEmpty(nginxIp)) {
            return request.getRemoteAddr();
        } else {
            return nginxIp;
        }
    }
}
