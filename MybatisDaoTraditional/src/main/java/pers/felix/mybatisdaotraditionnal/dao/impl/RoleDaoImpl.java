package pers.felix.mybatisdaotraditionnal.dao.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pers.felix.mybatisdaotraditionnal.dao.RoleDao;
import pers.felix.mybatisdaotraditionnal.entity.Role;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Felix Lee
 * @date 2022/5/5 19:34
 * @description
 */
public class RoleDaoImpl implements RoleDao {
    public List<Role> findAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Role> roleList = sqlSession.selectList("RoleMapper.selectAll");
        sqlSession.close();
        return roleList;
    }
}
