package com.zl.awesome.javase;

import com.zl.awesome.model.Student;
import com.zl.awesome.model.Study;
import org.junit.Test;

import java.util.*;

/**
 * @author: netposa
 * @Date: 2020/12/14 11:20
 * @Description:
 */
public class ArrayListTest {
    @Test
    public void test(){
        int length = 10000000;
        List a1 = new ArrayList();
        List ll = new LinkedList();
        long startA = System.currentTimeMillis();
        for (int i = 0; i <length; i++) {
            a1.add(11);
        }
        long endA = System.currentTimeMillis();
        System.out.println(endA-startA+"ArrayList");

        long startB = System.currentTimeMillis();
        for (int i = 0; i <length; i++) {
            ll.add(i);
        }
        long endB = System.currentTimeMillis();
        System.out.println(endB-startB+"LinkedList");
    }


    /**
     * 浅拷贝
     * @throws CloneNotSupportedException
     */
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        Student old = new Student("zl", 23);
        Study stOld = new Study();
        stOld.setMath("11");
        old.setStudy(stOld);

        Student new1 = (Student) old.clone();
        old.getStudy().setMath("22");
        old.setAge(20);

        System.out.println("old math String:"+old.getStudy().getMath());
        System.out.println("new1 math String:"+new1.getStudy().getMath());
        System.out.println("old age int:"+old.getAge());
        System.out.println("new1 age int :"+new1.getAge());
        System.out.println("new1 study :"+new1.getStudy());
        System.out.println("old study:"+old.getStudy());
    }

    /**
     * 在 subList 中，高度注意对原集合元素个数的修改，
     * 会导致子list的遍历、增加、 删除均会产生ConcurrentModificationException 异常。
     */
    @Test
    public void testSubList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        List<String> strings = list.subList(0, 3);
        list.set(2,"6666");
        System.out.println(strings.get(0));
        //fail-fast   错误检测机制
        /*list.add(3,"a");
        System.out.println(strings.get(2));*/
        list.remove(2);
        System.out.println(strings.get(2));
    }

    @Test
    public void testArrays(){
        //test1(new String[]{"1"});
        Long[] arr = new Long[]{1l,4l,3l,3l};
        //自动拆装箱对数组没有用
        /*int i = 2;
        String[] str  = new String[]{"1","4","3","3"};*/
        List list = Arrays.asList(arr);//基本类型不支持泛型化  数组不支持向下转型
        System.out.println(list.size());



        /*String[] arr1 = new String[]{"1","4","3","3"};
        List list1 = Arrays.asList(arr1);
        //list.add(4);
        System.out.println(list1.size());*/





        /*list1.set(0,"11");
        System.out.println(Arrays.toString(arr1));

        List list2 = Arrays.asList(4,3,3,4,5,6);
        System.out.println(list2.size());

        List list3 = new ArrayList(Arrays.asList(4,3,3,4,5,6));
        System.out.println(list3.size());*/
    }

    /**
     * 不可变集合
     */
    @Test
    public void unmodifiable() {
        List list = new ArrayList(Arrays.asList(4,3,3,4,5,6));//缓存不可变配置
        List modilist = Collections.unmodifiableList(list);//只读
        modilist.set(0,1);
        //modilist.add(5,1);
//        list.set(0,1);
        System.out.println(modilist.get(0));
    }


    @Test
    public void DropFailFastTest(){
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ) {
            list.add(i + "");
        }
        Iterator<String> iterator = list.iterator();
        int i = 0 ;
        while(iterator.hasNext()) {
            if (i == 3) {
                iterator.remove(); //迭代器的remove()方法
            }
            System.out.println(iterator.next());
            i ++;
        }
    }

    @Test
    public void DropNotFailFastTest(){
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ) {
            list.add(i + "");
        }
        Iterator<String> iterator = list.iterator();
        int i = 0 ;
        while(iterator.hasNext()) {
            if (i == 2) {
                iterator.remove(); //迭代器的remove()方法
            }
            System.out.println(iterator.next());
            i ++;
        }
    }
}
