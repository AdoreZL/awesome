package com.zl.awesome.transbean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: netposa
 * @Date: 2021/1/24 16:13
 * @Description:
 */
@Data
public class StudentDTO {
    private String name;

    private Integer age;

    private String no;

    private List<String> subjects;

    private Course course;

    private String createDate;
}