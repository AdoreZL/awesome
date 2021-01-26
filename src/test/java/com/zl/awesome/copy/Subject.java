package com.zl.awesome.copy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: netposa
 * @Date: 2021/1/26 14:49
 * @Description:
 */
@Data
@AllArgsConstructor
public class Subject implements Cloneable{
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //Subject 如果也有引用类型的成员属性，也应该和 Student 类一样实现
        return super.clone();
    }

    @Override
    public String toString() {
        return "Subject{" +this.hashCode()+
                "name='" + name + '\'' +
                '}';
    }
}
