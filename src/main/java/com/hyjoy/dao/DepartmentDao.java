package com.hyjoy.dao;

import com.hyjoy.domain.Department;

import java.util.List;

/**
 * 部门管理的Dao
 * Created by hyjoy on 2018/3/25.
 */
public interface DepartmentDao {
    int findCount();

    List<Department> findByPage(int begin, int pageSize);

    void save(Department department);

    Department findOne(Integer id);

    void update(Department department);

    /**
     * 删除部门
     *
     * @param department
     */
    void delete(Department department);


    /**
     * 查询所有部门的方法
     *
     * @return
     */
    List<Department> findAll();
}
