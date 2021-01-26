package com.zl.awesome.transbean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author: netposa
 * @Date: 2021/1/24 16:20
 * @Description:
 */
@Data
@ToString
public class StudentDO {
    private String name;

    private String age;

    private String number;

    private List<String> subjects;

    private Course course;

    private Date createDate;
}
