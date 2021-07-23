package com.zl.awesome.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: netposa
 * @Date: 2021/4/7 10:43
 * @Description: 字符串压缩
 */
@Slf4j
public class StringCompressionDemo {
    public static String doDepress(String str){
        //字符串为空直接返回
        if("".equals(str)){
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        //用第n个字符去和n+1个字符去比对
        char c = str.charAt(0);
        //记录字符出现次数，默认为1
        int repeat=1;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                //如果第n个字符和第n+1个字符相等，则出现次数+1
                repeat++;
            } else {
                //如果第n个字符和第n+1个字符不相等，则拼接在字符串后面
                stringBuilder.append(c).append(repeat);
                //拼接完后重置当前字符串
                c = str.charAt(i);
                //重置字符出现次数
                repeat = 1;
            }
        }
        //最后一组在for循环里是没有拼接的，这里再来拼接
        return stringBuilder.append(c).append(repeat).toString();
    }

    public static void main(String[] args) {
        log.info("我爱百词斩=======>{}",doDepress("我爱百词斩"));//我爱百词斩=======>我1爱1百1词1斩1
        log.info("我爱百百词词斩斩==>{}",doDepress("我爱百百词词斩斩"));//我爱百百词词斩斩==>我1爱1百2词2斩2
        log.info("aabcccccaaa===>{}",doDepress("aabcccccaaa"));//aabcccccaaa===>a2b1c5a3

    }
}
