import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pers.felix.mybatisdaoproxy.entity.Role;
import pers.felix.mybatisdaoproxy.mapper.RoleMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Felix Lee
 * @date 2023-03-19 23:39:58
 * @description
 */
public class SelectTest {

    @Test
    public void selectAllTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> allRole =  roleMapper.selectAll();
        System.out.println(allRole);
        sqlSession.close();
    }

    @Test
    public void selectByIdTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.selectById("6");
        System.out.println(role);
        sqlSession.close();
    }

    @Test
    public void multipleConditionTest() throws IOException {
        String addr = "东京";
        String level = "一年生";
        addr = "%" + addr + "%";
        level = "%" + level + "%";

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = roleMapper.selectByMultipleCondition(addr, level);
        System.out.println(roleList);
        sqlSession.close();
    }

    @Test
    public void singleConditionDynamic() throws IOException {
        String addr = "%" + "东京" + "%";
        String level = "%" + "一年生" + "%";
        String category = "%" + "咒术师" + "%";

        Role role = new Role();
//        role.setRoleAddr(addr);
        role.setRoleLevel(level);
//        role.setRoleCategory(category);

        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = roleMapper.selectBySingleCondition(role);
        System.out.println(roleList);
        sqlSession.close();
    }
}
