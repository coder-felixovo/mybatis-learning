package pers.felix.mybatisanno.entity;

import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-06 23:07:55
 */
public class Employee {
    private int id;
    private String name;
    private int deptId;
    private Department department; // 员工所在的部门
    private List<Role> roleList; // 员工担任的角色

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}

