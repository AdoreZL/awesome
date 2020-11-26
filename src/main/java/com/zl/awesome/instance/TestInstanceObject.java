package com.zl.awesome.instance;

/**
 * @author: netposa
 * @Date: 2020/11/25 20:57
 * @Description:
 */
public class TestInstanceObject {
    public static void main(String[] args) {
        Apple a = new Apple(50, 2);

        System.out.println("苹果的重量是" + a.weight + "苹果的单价是" + a.price);
        System.out.println("子类中的weight属性值为" + a.getWeight());
        System.out.println("父类中的weight属性值为" + a.getSuperWeight());
    }

}

class Fruit{
    int weight;
    int price;

    public Fruit() {
        System.out.println("这是Fruit类的无参构造方法");
    }

    public Fruit(int weight, int price) {
        this.weight = weight;
        this.price = price;
        System.out.println("我是Fruit类具有两个整型参数的构造方法，我完成对从我这里继承的属性的初始化，即使weight属性被隐藏了");
    }
}

class Apple extends Fruit{
    int weight =45;

    public Apple(){
        System.out.println("我是Apple类的无参构造方法，我会隐式调用父类的无参构造方法来完成相应于此处所产生的子类对象的父类对象");
    }

    public Apple(int weight, int price)
    {
        super(weight, price);  //call the parent constructormethod

        System.out.println("我是Apple类具有两个整型参数的构造方法，我显式调用了父类的具有两个整型参数的构造方法");
    }

    public int getWeight()
    {
        return weight;
    }

    public int getSuperWeight()
    {
        return super.weight;
    }
}
