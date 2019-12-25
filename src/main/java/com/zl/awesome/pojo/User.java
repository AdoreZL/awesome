package com.zl.awesome.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "User")
public class User{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "nickname")
    private String userNickname;

    @Column(name = "password")
    private String userPassword;

    @Column(name = "email")
    private String userEmail;

    private String ext1;

    private String ext2;

    private String ext3;

    @Column(name = "createtime")
    private String  createTime;

}
