package pers.felix.mybatisdaoproxy.mapper;

import pers.felix.mybatisdaoproxy.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    // 查询全部用户
    List<User> getAllUsers();

    // 根据id修改用户名字
    int updateNameById(User user);

    // 根据id删除用户
    int deleteById(int id);

    // 新增用户
    int addUser(User user);

    // 多条件查询
    List<User> selectByMultipleCondition(@Param("name") String name, @Param("age") int age);

    // 单条件动态查询
    List<User> selectBySingleCondition(User user);
}
