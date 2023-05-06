package pers.felix.mybatisdaotraditional.dao.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pers.felix.mybatisdaotraditional.dao.PersonDao;
import pers.felix.mybatisdaotraditional.entity.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Felix Lee
 * @date 2022/5/5 19:34
 * @description
 */
public class PersonDaoImpl implements PersonDao {
    @Override
    public List<Person> selectAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Person> personList = sqlSession.selectList("PersonMapper.selectAll");
        sqlSession.close();
        return personList;
    }
}
