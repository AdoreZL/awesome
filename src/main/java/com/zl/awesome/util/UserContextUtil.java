package com.zl.awesome.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
public class UserContextUtil {

    // header中tokenId
    public final String TOKENID_HEADER = "access_token";



    /**
     * 解析request中的access_token
     *
     * @param request
     * @return
     */
    public String initInstanceParam(HttpServletRequest request) {
        String token = request.getHeader(TOKENID_HEADER);
        if(token==null||"".equals(token)){
            token = getTokenIdFromCookie(request);
        }
        log.info("获取到的tokenId:" + token);
        return token;
    }

    /**
     * 通过Cookie读取用户的tokenId
     *
     * @param request
     * @return
     */
    private String getTokenIdFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String tokenId = null; //用户tokenId
        //通过cookie获取tokenId
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (TOKENID_HEADER.equals(cookie.getName())) {
                    tokenId = cookie.getValue();
                    break;
                }
            }
        }
        return tokenId;
    }

}
