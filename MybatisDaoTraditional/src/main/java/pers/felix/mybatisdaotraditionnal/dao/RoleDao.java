package pers.felix.mybatisdaotraditionnal.dao;

import pers.felix.mybatisdaotraditionnal.entity.Role;

import java.io.IOException;
import java.util.List;

/**
 * @author  Felix Lee
 * @date 2022/5/5 19:33
 * @description
 */
public interface RoleDao {
    List<Role> findAll() throws IOException;
}
