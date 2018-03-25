package com.hyjoy.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门的实体
 * Created by hyjoy on 2 018/3/25.
 */
@Data
public class Department {
    private Integer did;
    private String dname;
    private String ddesc;
    // 员工的集合
    private Set<Employee> employees = new HashSet<Employee>();
}
