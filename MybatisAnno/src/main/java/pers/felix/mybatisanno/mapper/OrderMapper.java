package pers.felix.mybatisanno.mapper;

import pers.felix.mybatisanno.entity.Order;
import pers.felix.mybatisanno.entity.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author  Felix Lee
 * @date 2022/5/23 15:31
 * @description
 */
public interface OrderMapper {
    @Select("select * from orders")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "ordertime",column = "ordertime"),
            @Result(property = "total",column = "total"),
            @Result(property = "user",column = "uid",
            javaType = User.class,
            one = @One(select = "pers.felix.mybatisanno.mapper.UserMapper.findById")),
    })
    List<Order> findAll();

    @Select("select * from orders where uid=#{uid}")
    List<Order> findByUid(int uid);
}
