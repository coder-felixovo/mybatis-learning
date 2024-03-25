package pers.felix.mybatisdaotraditional.dao;

import pers.felix.mybatisdaotraditional.entity.User;

import java.io.IOException;
import java.util.List;

/**
 * @author Felix Lee
 * @date 2022/5/5 19:33
 * @description
 */
public interface UserDao {
    List<User> getAllUsers() throws IOException;
}
