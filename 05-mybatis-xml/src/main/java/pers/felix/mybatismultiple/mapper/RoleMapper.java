package pers.felix.mybatismultiple.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pers.felix.mybatismultiple.entity.Role;

import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-07 12:01:50
 */
public interface RoleMapper {
    List<Role> selectRoleByEmployeeId(int employeeId);
}
