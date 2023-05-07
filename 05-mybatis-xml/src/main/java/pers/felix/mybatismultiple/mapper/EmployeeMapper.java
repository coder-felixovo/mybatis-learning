package pers.felix.mybatismultiple.mapper;

import org.apache.ibatis.annotations.*;
import pers.felix.mybatismultiple.entity.Employee;

import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-07 11:20:55
 */
public interface EmployeeMapper {
    // 根据id查询员工及其所属部门
    Employee selectEmployeeByIdWithDepartment(int id);

    // 查询所有员工，以及担任的角色
    List<Employee> selectAllEmployeeWithRole();
}
