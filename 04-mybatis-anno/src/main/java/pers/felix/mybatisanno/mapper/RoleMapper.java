package pers.felix.mybatisanno.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pers.felix.mybatisanno.entity.Role;

import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-07 10:03:48
 */
public interface RoleMapper {

    // 根据员工id查询员工担任的角色
    @Select("SELECT r.id as id, name FROM role r, employee_role er WHERE er.role_id = r.id AND er.employee_id=#{employeeId}")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name")
    })
    List<Role> selectRoleByEmployeeId(int employeeId);
}
