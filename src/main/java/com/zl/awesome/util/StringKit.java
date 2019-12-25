package com.zl.awesome.util;

/**
  * @ClassName: StringKit
  * @Description: 字符串操作工具
  * @author fangyuan_xa
  * @date 2016年5月30日 下午4:59:00
  *
  */
public class StringKit {

    /**
      * @Title: isEmpty
      * @Description: 判断字符串是否为空
      * @param str
      * @return
      */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

}
