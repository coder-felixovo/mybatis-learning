package pers.felix.mybatismultiple.entity;

import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private int id;
    private String name;
    private int deptId;
    private Department department; // 员工所在的部门
    private List<Role> roleList; // 员工担任的角色
}