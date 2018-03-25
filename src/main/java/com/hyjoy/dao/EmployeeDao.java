package com.hyjoy.dao;

import com.hyjoy.domain.Employee;

import java.util.List;

/**
 * Created by hyjoy on 2018/3/25.
 */
public interface EmployeeDao {
    Employee findByUsernameAndPassword(Employee employee);

    int findCount();

    List<Employee> findByPage(int begin, int pageSize);

    void save(Employee employee);

    Employee findOne(Integer eid);

    void update(Employee employee);

    void delete(Employee employee);
}
