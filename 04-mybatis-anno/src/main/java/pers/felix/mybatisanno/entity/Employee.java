package pers.felix.mybatisanno.entity;

import lombok.Data;

import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-06 23:07:55
 */
@Data
public class Employee {
    private int id;
    private String name;
    private int deptId;
    private Department department; // 员工所在的部门
    private List<Role> roleList; // 员工担任的角色
}

