package com.hyjoy.action;

import com.hyjoy.domain.Department;
import com.hyjoy.domain.PageBean;
import com.hyjoy.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by hyjoy on 2018/3/25.
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

    // 模型驱动使用的对象
    private Department department = new Department();
    private Integer currPage = 1;
    private DepartmentService departmentService;

    @Override
    public Department getModel() {
        return department;
    }


    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String findAll() {
        PageBean<Department> pageBean = departmentService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "list";
    }

    /**
     * 跳转到添加部门的页面的方法
     *
     * @return
     */
    public String saveUI() {
        return "saveUI";
    }

    /**
     * 添加部门的执行的方法
     *
     * @return
     */
    public String save() {
        departmentService.save(department);
        return "saveSuccess";
    }

    /**
     * 编辑部门的执行的方法
     *
     * @return
     */
    public String edit() {
        department = departmentService.findOne(department.getDid());
        return "editSuccess";
    }

    /**
     * 修改部门的执行的方法
     *
     * @return
     */
    public String update() {
        departmentService.update(department);
        return "updateSuccess";
    }

    /**
     * 删除部门的执行的方法
     *
     * @return
     */
    public String delete() {
        department = departmentService.findOne(department.getDid());// 可以进行级联删除
        departmentService.delete(department);
        return "deleteSuccess";
    }
}
