package com.hyjoy.service;

import com.hyjoy.domain.Employee;
import com.hyjoy.domain.PageBean;

/**
 * 员工管理的业务层接口
 * Created by hyjoy on 2018/3/25.
 */
public interface EmployeeService {
    Employee login(Employee employee);

    PageBean<Employee> findByPage(Integer page);

    void save(Employee employee);

    Employee findOne(Integer id);

    void update(Employee employee);

    void delete(Employee employee);
}
