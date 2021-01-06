package com.zl.awesome.pattern.proxy.staticproxy;

import com.zl.awesome.pattern.proxy.Person;

/**
 * @author: netposa
 * @Date: 2020/12/3 16:48
 * @Description:
 */
public class Father {
    private Person person;

    public Father(Person person){
        this.person=person;
    }

    public void findLove(){
        System.out.println("父亲物色对象");
        this.person.findLove();
        System.out.println("双方父母同意，确立关系");
    }
}
