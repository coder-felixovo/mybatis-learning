package pers.felix.mybatismultiple.entity;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private int id;
    private String name;
    private List<Employee> employeeList; // 一个部门可以有多名员工
}
