package pers.felix.mybatismultiple.mapper;

import pers.felix.mybatismultiple.entity.User;

import java.util.List;

/*
 * author  Felixovo
 * date 2022/5/23 8:19
 */
public interface UserMapper {
    List<User> findAll();
    List<User> findAllUserAndRole();
}
