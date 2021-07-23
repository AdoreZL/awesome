package com.zl.awesome.noifelse;

import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: netposa
 * @Date: 2021/4/21 14:28
 * @Description:
 */
public class UserPayServiceStrategyFactory {
    private static Map<String,UserPayService> services = new ConcurrentHashMap<String,UserPayService>();

    public  static UserPayService getByUserType(String type){
        return services.get(type);
    }

    public static void register(String userType,UserPayService userPayService){
        Assert.notNull(userType,"userType can't be null");
        services.put(userType,userPayService);
    }
}
