package pers.felix.mybatisdynamic.mapper;


import pers.felix.mybatisdynamic.domain.Role;

import java.util.List;

/**
 * @author  Felix Lee
 * @date 2022/5/22 14:17
 * @description
 */
public interface RoleMapper {
    Role findByCondition(Role role);
    List<Role> findByIds(List<String> ids);
}
