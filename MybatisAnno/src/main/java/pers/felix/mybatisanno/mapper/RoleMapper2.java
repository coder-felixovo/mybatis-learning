package pers.felix.mybatisanno.mapper;

import pers.felix.mybatisanno.entity.Role2;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author  Felix Lee
 * @date 2022/5/23 16:01
 * @description
 */
public interface RoleMapper2 {
    @Select("select * from role2 r,user_role ur where r.id=ur.role_id and ur.user_id = #{uid}")
    List<Role2> findByUid(int uid);
}
