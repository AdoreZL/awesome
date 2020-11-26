package com.zl.awesome.pattern.abstactfactory;

import com.zl.awesome.pattern.factory.simplefactory.ICourse;
import com.zl.awesome.pattern.factory.simplefactory.JavaCourse;

/**
 * @author: netposa
 * @Date: 2020/11/10 11:53
 * @Description:
 */
public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVedio() {
        return new JavaVideo();
    }
}
