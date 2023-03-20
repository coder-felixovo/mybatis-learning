package pers.felix.mybatisanno.mapper;

import pers.felix.mybatisanno.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author  Felix Lee
 * @date 2022/5/23 15:02
 * @description
 */
public interface RoleMapper {
    @Insert("insert into role(role_id, role_name, role_addr, role_level) values(#{roleId}, #{roleName}, #{roleAddr},#{roleLevel})")
    public void insert(Role role);

    @Update("update role set role_name=#{roleName} where role_id=#{roleId}")
    public void update(Role role);

    @Delete("delete from role where role_id=#{roleId}")
    public void delete(String roleId);

    @Select("select " +
            "role_id as roleId," +
            "role_name as roleName," +
            "role_addr as roleAddr," +
            "role_level as roleLevel," +
            "role_category as roleCategory" +
            " from role")
    public List<Role> selectAll();
}
