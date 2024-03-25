package pers.felix.mybatisdaotraditional.dao.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pers.felix.mybatisdaotraditional.dao.UserDao;
import pers.felix.mybatisdaotraditional.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Felix Lee
 * @date 2022/5/5 19:34
 * @description
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAllUsers() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("UserMapper.getAllUsers");
        sqlSession.close();
        return userList;
    }
}
