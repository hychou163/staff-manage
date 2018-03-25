package com.hyjoy.dao.impl;

import com.hyjoy.domain.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by hyjoy on 2018/3/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class DepartmentDaoImplTest {
    @Autowired
    private DepartmentDaoImpl departmentDao;

    @Test
    public void findCount() {
        int count = departmentDao.findCount();
        Assert.assertEquals(1, count);
    }

    @Test
    public void findByPage() {
    }

    @Test
    public void save() {
        Department department = new Department();
        department.setDname("技术部门");
        department.setDdesc("技术开发部门");
        departmentDao.save(department);
    }

    @Test
    public void findOne() {
        Department department = departmentDao.findOne(1);
        Assert.assertNotNull(department);
    }

    @Test
    public void update() {
        Department department = new Department();
        department.setDid(1);
        department.setDdesc("技术开发部门 11111");
        departmentDao.update(department);
    }

    @Test
    public void delete() {
    }

    @Test
    public void findAll() {
        List<Department> departments = departmentDao.findAll();
        Assert.assertNotNull(departments);
    }
}