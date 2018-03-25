package com.hyjoy.service.impl;

import com.hyjoy.dao.DepartmentDao;
import com.hyjoy.domain.Department;
import com.hyjoy.domain.PageBean;
import com.hyjoy.service.DepartmentService;

import java.util.List;

/**
 * Created by hyjoy on 2018/3/25.
 */
public class DepartmentServiceImpl implements DepartmentService {
    //注入部门管理的DAO
    private DepartmentDao departmentDao;


    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public PageBean<Department> findByPage(Integer page) {
        PageBean<Department> pageBean = new PageBean<Department>();
        //封装当前页数
        pageBean.setCurrPage(page);
        //封装每页显示记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        //封装每页显示的数据
        int begin = (page - 1) * pageSize;
        List<Department> list = departmentDao.findByPage(begin, pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Override
    public Department findOne(Integer id) {
        return departmentDao.findOne(id);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public void delete(Department department) {
        departmentDao.delete(department);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
