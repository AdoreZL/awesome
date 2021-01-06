package com.zl.awesome.javase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: netposa
 * @Date: 2021/1/6 15:08
 * @Description:
 */
public class stream {
    public static void main(String[] args) {
        List<String> sourceList =new ArrayList<>();
        sourceList.add("1");
        sourceList.add("2");
        sourceList.add("3");
        List<String> targetList=new ArrayList<>();
        targetList.add("3");
        targetList.add("4");
        targetList.add("2");
        targetList.add("5");

        //求与目标List的交集
        List<String> noChangeIds = sourceList.stream().filter(source -> targetList.contains(source)).collect(Collectors.toList());
        System.out.println("noChangeIds_"+noChangeIds.toString());

        //求与目标List的差集
        List<String> waitDelIds = sourceList.stream().filter(source -> !targetList.contains(source)).collect(Collectors.toList());
        System.out.println("waitDelIds" + waitDelIds.toString());

        //求与原list的差集
        List<String> waitInsert = targetList.stream().filter(target -> !sourceList.contains(target)).collect(Collectors.toList());
        System.out.println("waitInsert" + waitInsert.toString());


    }
}
