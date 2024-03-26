package pers.felix.mybatisanno.entity;

import lombok.Data;

import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-06 20:49:06
 */
@Data
public class Department {
    private int id;
    private String name;
    private List<Employee> employeeList; // 一个部门可以有多名员工
}
