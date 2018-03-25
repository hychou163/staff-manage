package com.hyjoy.service;

import com.hyjoy.domain.Department;
import com.hyjoy.domain.PageBean;

import java.util.List;

/**
 * Created by hyjoy on 2018/3/25.
 */
public interface DepartmentService {
    PageBean<Department> findByPage(Integer page);

    void save(Department department);

    Department findOne(Integer id);

    void update(Department department);

    void delete(Department department);

    List<Department> findAll();
}
