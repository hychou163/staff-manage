package com.hyjoy.domain;

import lombok.Data;

import java.util.Date;

/**
 * 员工实体
 * Created by hyjoy on 2018/3/25.
 */
@Data
public class Employee {
    private Integer eid;
    private String ename;
    private String sex;
    private Date birthday;
    private Date joinDate;
    private String eno;
    private String username;
    private String password;

    private Department department;
}
