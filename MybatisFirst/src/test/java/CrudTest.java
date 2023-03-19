import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pers.felix.mybatisfirst.Role;

import java.io.IOException;
import java.io.InputStream;

/**
 *@author Felix Lee
 *@date 2023-03-19 20:24:10
 *@description
 */
public class CrudTest {

    @Test
    public void insertTest() throws IOException {
        // 生成Role实例
        Role role = new Role();
        role.setRoleId("1");
        role.setRoleName("五条悟");
        role.setRoleAddr("东京");
        role.setRoleLevel("特级");
        role.setRoleCategory("咒术师");
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insert = sqlSession.insert("RoleMapper.addRole", role);
        System.out.println(insert); // 1
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateTest() throws IOException {
        Role role = new Role();
        role.setRoleId("1");
        role.setRoleName("五条悟-update");
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int update = sqlSession.update("RoleMapper.updateRoleName", role);
        System.out.println(update); // 1
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int delete = sqlSession.delete("RoleMapper.deleteRole","1");
        System.out.println(delete); // 1
        sqlSession.commit();
        sqlSession.close();
    }

}
