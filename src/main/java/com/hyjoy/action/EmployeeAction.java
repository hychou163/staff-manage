package com.hyjoy.action;

import com.hyjoy.domain.Department;
import com.hyjoy.domain.Employee;
import com.hyjoy.domain.PageBean;
import com.hyjoy.service.DepartmentService;
import com.hyjoy.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * 员工管理的Action类
 * Created by hyjoy on 2018/3/25.
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

    // 模型驱动使用的对象
    private Employee employee = new Employee();
    // 注入业务层类
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    // 接收当前的页数
    private Integer currPage = 1;

    @Override
    public Employee getModel() {
        return employee;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 登录执行的方法
     *
     * @return
     */
    public String login() {
        System.out.println("Login执行了。。。。");
        //调用业务层的类；
        Employee existEmployee = employeeService.login(employee);
        if (existEmployee == null) {
            //登录失败
            this.addActionError("用户名或密码错误！");
            System.out.println("用户名或密码错误");

            return INPUT;
        } else {
            //登录成功
            ActionContext.getContext().getSession().put("existEmployee", existEmployee);
            System.out.println("登录成功");

            return SUCCESS;
        }
    }

    /**
     * 分页查询员工的执行的方法
     */
    public String findAll() {
        PageBean<Employee> pageBean = employeeService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    /**
     * 跳转到添加员工页面的执行的方法
     */
    public String saveUI() {
        //查询所有部门
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list", list);
        return "saveUI";
    }

    /**
     * 保存员工执行的方法
     */
    public String save() {
        employeeService.save(employee);
        return "saveSuccess";
    }

    /**
     * 编辑员工的执行的方法
     */
    public String edit() {
        //根据员工ID查询员工
        employee = employeeService.findOne(employee.getEid());
        //查询所有的部门
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list", list);
        return "editSuccess";
    }

    /**
     * 修改员工执行的方法
     */
    public String update() {
        employeeService.update(employee);
        return "updateSuccess";
    }

    /**
     * 删除员工的执行的方法
     */
    public String delete() {
        employee = employeeService.findOne(employee.getEid());
        employeeService.delete(employee);
        return "deleteSuccess";
    }
}
