import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pers.felix.mybatisdaoproxy.entity.User;
import pers.felix.mybatisdaoproxy.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Felix
 * @date 2023-05-06 17:27:57
 */
public class MybatisDaoProxyTest {
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setId(3);
        user.setName("宫水三叶");
        user.setAge(17);

        User user1 = new User();
        user1.setId(100);
        user1.setName("测试用户");
        user1.setAge(18);

        int affectedRows = userMapper.addUser(user);
        System.out.println(affectedRows);
        affectedRows = userMapper.addUser(user1);
        System.out.println(affectedRows);
    }

    @Test
    public void testSelect() {
        List<User> personList = userMapper.getAllUsers();
        System.out.println(personList);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(100);
        user.setName("测试-update");
        int affectedRows = userMapper.updateNameById(user);
        System.out.println(affectedRows);
    }

    @Test
    public void testDelete() {
        int affectedRows = userMapper.deleteById(100);
        System.out.println(affectedRows);
    }

    @Test
    public void testSelectByMultipleCondition() {
        List<User> personList = userMapper.selectByMultipleCondition("宫水三叶", 17);
        System.out.println(personList);
    }

    @Test
    public void testDynamic() {
        User user = new User();
        user.setName("岩户铃芽");
//        user.setAge(17);
        List<User> personList = userMapper.selectBySingleCondition(user);
        System.out.println(personList);
    }
}
