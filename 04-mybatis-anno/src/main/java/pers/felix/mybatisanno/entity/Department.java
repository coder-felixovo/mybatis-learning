package pers.felix.mybatisanno.entity;

import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-06 20:49:06
 */
public class Department {
    private int id;
    private String name;

    private List<Employee> employeeList; // 一个部门可以有多名员工

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

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
