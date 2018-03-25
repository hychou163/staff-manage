package com.hyjoy.dao.impl;

import com.hyjoy.dao.DepartmentDao;
import com.hyjoy.domain.Department;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by hyjoy on 2018/3/25.
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    @Override
    public int findCount() {
        String hql = "select count(*) from Department";
        List<Long> list = this.getHibernateTemplate().find(hql);
        if (list.size() > 0) return list.get(0).intValue();
        return 0;
    }

    /**
     * 分页查询部门
     *
     * @param begin
     * @param pageSize
     * @return
     */
    @Override
    public List<Department> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
        List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
        return list;
    }

    @Override
    public void save(Department department) {
        this.getHibernateTemplate().save(department);
    }

    /**
     * 根据部门的id查询部门的方法
     *
     * @param id
     * @return
     */
    @Override
    public Department findOne(Integer id) {
        return this.getHibernateTemplate().get(Department.class, id);
    }

    @Override
    public void update(Department department) {
        this.getHibernateTemplate().update(department);
    }


    @Override
    public void delete(Department department) {
        this.getHibernateTemplate().delete(department);
    }

    @Override
    public List<Department> findAll() {
        return this.getHibernateTemplate().find("from Department");
    }
}
