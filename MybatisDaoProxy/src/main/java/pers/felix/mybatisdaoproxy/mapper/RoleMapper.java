package pers.felix.mybatisdaoproxy.mapper;

import pers.felix.mybatisdaoproxy.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    // 查询全部
    List<Role> selectAll();

    // 根据id查询
    Role selectById(String id);

    // 根据id删除
    int deleteById(String id);

    // 添加数据
    int add(Role role);

    // 多条件查询
    List<Role> selectByMultipleCondition(@Param("addr") String role_addr, @Param("level") String role_level);

    // 单条件动态查询
    List<Role> selectBySingleCondition(Role role);
}
