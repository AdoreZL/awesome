package com.boot.placms.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "type")
public class Type {
    @Id
    //通常我们采用的是 IDENTITY。主键由数据库自动生成（主要是自动增长型）。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
}
