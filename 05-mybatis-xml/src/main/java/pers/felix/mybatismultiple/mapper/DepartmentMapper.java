package pers.felix.mybatismultiple.mapper;

import org.apache.ibatis.annotations.*;
import pers.felix.mybatismultiple.entity.Department;

import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-07 10:54:35
 */
public interface DepartmentMapper {

    int insertDepartment(Department department);

    int deleteDepartment(int id);

    List<Department> selectAllDepartment();

    int updateDepartmentName(Department department);

    Department selectDepartmentById(int id);

    // 根据id查询部门，并查询该部门下所有员工
    // 一个部门有多名员工
    Department selectDepartmentByIdWithEmployee(int id);
}
