import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pers.felix.mybatisdaoproxy.entity.Role;
import pers.felix.mybatisdaoproxy.mapper.RoleMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Felix Lee
 * @date 2023-03-19 23:08:46
 * @description
 */
public class InsertTest {
    @Test
    public void insertTest() throws IOException {
        Role role = new Role();
        role.setRoleId("6");
        role.setRoleName("东堂葵");
        role.setRoleAddr("京都");
        role.setRoleLevel("三年生");
        role.setRoleCategory("咒术师");

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        int result =  roleMapper.add(role);
        System.out.println(result);
        sqlSession.close();
    }
}
