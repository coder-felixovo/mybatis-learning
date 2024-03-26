package pers.felix.mybatisanno.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import pers.felix.mybatisanno.entity.Department;
import pers.felix.mybatisanno.entity.Employee;
import pers.felix.mybatisanno.entity.Role;

import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-06 23:11:04
 */
public interface EmployeeMapper {

    @Insert("INSERT INTO employee (id, name, dept_id) VALUES(#{id}, #{name}, #{deptId})")
    int insertEmployee(Employee employee);

    @Select("SELECT id, name FROM employee")
    List<Employee> selectAllEmployee();

    // 根据id查询员工
    @Select("SELECT id, name, dept_id FROM employee WHERE id=#{id}")
    Employee selectEmployeeById(int id);

    // 根据id查询员工，并查询其所在部门
    // 一名员工属于一个部门
    @Select("SELECT id, name, dept_id FROM employee WHERE id = #{id}")
    @Results(id = "employeeAndDepartment", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "dept_id", property = "department",
                    javaType = Department.class,
                    one=@One(select = "pers.felix.mybatisanno.mapper.DepartmentMapper.selectDepartmentById"))
    })
    Employee selectEmployeeByIdWithDepartment(int id);

    // 根据部门id查询所有员工
    @Select("SELECT id, name, dept_id FROM employee WHERE dept_id = #{deptId}")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "dept_id", property = "deptId")
    })
    List<Employee> selectAllEmployeeByDeptId(int deptId);

    // 查询所有员工，以及担任的角色
    @Select("SELECT id, name, dept_id FROM employee")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "id", property = "roleList",
                    javaType = List.class,
                    many = @Many(select = "pers.felix.mybatisanno.mapper.RoleMapper.selectRoleByEmployeeId")
            )
    })
    List<Employee> selectAllEmployeeWithRole();
}
