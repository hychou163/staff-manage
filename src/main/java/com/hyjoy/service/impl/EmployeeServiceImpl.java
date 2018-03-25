package com.hyjoy.service.impl;

import com.hyjoy.dao.EmployeeDao;
import com.hyjoy.domain.Employee;
import com.hyjoy.domain.PageBean;
import com.hyjoy.service.EmployeeService;

import java.util.List;

/**
 * 员工管理的业务层实现类
 * Created by hyjoy on 2018/3/25.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee login(Employee employee) {
        Employee ex = employeeDao.findByUsernameAndPassword(employee);
        return ex;
    }

    @Override
    public PageBean<Employee> findByPage(Integer page) {
        PageBean<Employee> pageBean = new PageBean<Employee>();
        // 封装当前页数
        pageBean.setCurrPage(page);
        int pageSize = 3;
        int totalCount = employeeDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        int begin = (page - 1) * pageSize;
        List<Employee> employees = employeeDao.findByPage(begin, pageSize);
        return pageBean;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Employee findOne(Integer id) {

        return employeeDao.findOne(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }
}
