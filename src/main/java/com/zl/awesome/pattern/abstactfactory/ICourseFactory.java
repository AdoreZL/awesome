package com.zl.awesome.pattern.abstactfactory;

import com.zl.awesome.pattern.factory.simplefactory.ICourse;

/**
 * @author: netposa
 * @Date: 2020/11/10 11:47
 * @Description:
 */
//要求所有的子工厂都实现这个工厂
public interface ICourseFactory {
    ICourse createCourse();

    INote createNote();

    IVideo createVedio();
}
