package pers.felix.mybatisanno.mapper;

import org.apache.ibatis.annotations.*;
import pers.felix.mybatisanno.entity.Department;
import pers.felix.mybatisanno.entity.Employee;

import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-06 20:53:57
 */
public interface DepartmentMapper {

    @Insert("INSERT INTO department (id, name) VALUES(#{id}, #{name})")
    int insertDepartment(Department department);

    @Delete("DELETE FROM department WHERE id=#{id}")
    int deleteDepartment(int id);

    @Select("SELECT id, name FROM department")
    List<Department> selectAllDepartment();

    @Update("UPDATE department SET name=#{name} WHERE id=#{id}")
    int updateDepartmentName(Department department);

    @Select("SELECT id, name FROM department WHERE id=#{id}")
    Department selectDepartmentById(int id);

    // 根据id查询部门，并查询该部门下所有员工
    // 一个部门有多名员工
    @Select("SELECT id, name FROM department WHERE id=#{id}")
    @Results(id = "departmentAndEmployee", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "employeeList", javaType = List.class,
                    many = @Many(select = "pers.felix.mybatisanno.mapper.EmployeeMapper.selectAllEmployeeByDeptId"))
    })
    Department selectDepartmentByIdWithEmployee(int id);

}
