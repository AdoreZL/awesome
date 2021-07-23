package com.zl.awesome.pattern.factorymethod;

import com.zl.awesome.pattern.factory.simplefactory.ICourse;

/**
 * @author: netposa
 * @Date: 2020/11/10 11:24
 * @Description:
 */
public interface ICourseFactory {
    ICourse create();
}
