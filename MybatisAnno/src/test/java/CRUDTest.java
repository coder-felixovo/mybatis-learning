import pers.felix.mybatisanno.entity.Role;
import pers.felix.mybatisanno.mapper.RoleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
 * @author Felix Lee
 * @date 2022/5/23 15:05
 * @description
 */
public class CRUDTest {
    private RoleMapper roleMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        roleMapper = sqlSession.getMapper(RoleMapper.class);
    }

    @Test
    public void insert() {
        Role role = new Role();
        role.setRoleId("100");
        role.setRoleName("测试删除");
        role.setRoleAddr("测试删除");
        role.setRoleLevel("测试删除");
        roleMapper.insert(role);
    }

    @Test
    public void update() {
        Role role = new Role();
        role.setRoleId("100");
        role.setRoleName("测试修改111");
        roleMapper.update(role);
    }

    @Test
    public void delete() {
        roleMapper.delete("100");
    }

    @Test
    public void selectAll() {
        List<Role> roleList = roleMapper.selectAll();
        for(Role role:roleList) {
            System.out.println(role);
        }
    }
}
