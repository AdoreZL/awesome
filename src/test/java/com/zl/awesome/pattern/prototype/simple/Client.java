package com.zl.awesome.pattern.prototype.simple;

/**
 * @author: netposa
 * @Date: 2020/12/3 11:50
 * @Description:
 */
public class Client {
//    private Prototype prototype;
//
//    public Client(Prototype prototype){
//        this.prototype=prototype;
//    }

    public Prototype startClone(Prototype concreatePrototype){
        return concreatePrototype.clone();
    }
}
