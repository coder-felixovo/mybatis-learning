package pers.felix.mybatisanno.mapper;

import pers.felix.mybatisanno.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author  Felix Lee
 * @date 2022/5/23 15:37
 * @description
 */
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User findById(int id);

    @Select("select * from user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "orderList",column = "id",
            javaType = List.class,
            many = @Many(select = "pers.felix.mybatisanno.mapper.OrderMapper.findByUid")),
    })
    List<User> findAllUserAndOrder();

    @Select("select * from user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "roleList",column = "id",
            javaType = List.class,
            many = @Many(select = "pers.felix.mybatisanno.mapper.RoleMapper2.findByUid")),
    })
    List<User> findAllUserAndRole2();
}
