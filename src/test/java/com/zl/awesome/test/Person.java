package com.zl.awesome.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: netposa
 * @Date: 2021/3/17 15:11
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private Integer id;
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }
}
