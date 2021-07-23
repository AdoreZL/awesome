package com.zl.awesome.filter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: netposa
 * @Date: 2021/4/6 15:16
 * @Description:
 */
@Slf4j
public class BloomFilterTest {
    public static void main(String[] args) {
        BloomFilterTest bloomFilter = new BloomFilterTest();
        log.info("对象的hashcode：{}", bloomFilter.hashCode());
        log.info("1433223的hashcode：{}", "1433223".hashCode());
        log.info("郭德纲的hashcode：{}", "郭德纲".hashCode());
        log.info("小郭德纲的hashcode：{}", "小郭德纲".hashCode());
        log.info("彭于晏的hashcode：{}", "彭于晏".hashCode());
        log.info("唱跳rap篮球的hashcode：{}", "唱跳rap篮球".hashCode());
    }
}
