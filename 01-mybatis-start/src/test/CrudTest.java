import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pers.felix.mybatisstart.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *@author Felix Lee
 *@date 2023-03-19 20:24:10
 *@description
 */
public class CrudTest {
    private SqlSession sqlSession;

    @Before
    public void beforeTest() throws IOException {
        // 加载核心配置文件 mybatis-config.xml
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 获得 SqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得 sqlSession 对象
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void afterTest() {
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void insertTest() throws IOException {

        User user = new User();
        user.setId(1);
        user.setName("岩户铃芽");
        user.setAge(17);

        User user1 = new User();
        user1.setId(2);
        user1.setName("宗像草太");
        user1.setAge(22);

        int affectedRows = sqlSession.insert("UserMapper.addUser", user);
        System.out.println(affectedRows); // 1

        affectedRows = sqlSession.insert("UserMapper.addUser", user1);
        System.out.println(affectedRows);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectTest() {
        List<User> personList = sqlSession.selectList("UserMapper.getAllUser");
        System.out.println(personList);
        sqlSession.close();
    }

    @Test
    public void updateTest() throws IOException {
        User user = new User();
        user.setName("岩户铃芽-update");
        user.setId(1);
        int affectedRows = sqlSession.update("UserMapper.updateNameById", user);
        System.out.println(affectedRows); // 1
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteTest() throws IOException {
        int affectedRows = sqlSession.delete("UserMapper.deleteUserById",2);
        System.out.println(affectedRows); // 1
        sqlSession.commit();
        sqlSession.close();
    }

}
