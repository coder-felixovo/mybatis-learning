import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pers.felix.mybatisstart.entity.Person;

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
    public void testInsert() throws IOException {
        // 生成Role实例
        Person person = new Person();
        person.setId(1);
        person.setName("岩户铃芽");
        person.setAge(17);
        person.setAddress("九州");
        int affectedRows = sqlSession.insert("PersonMapper.insertPerson", person);
        System.out.println(affectedRows); // 1
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelect() {
        List<Person> personList = sqlSession.selectList("PersonMapper.selectAll");
        System.out.println(personList);
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        Person person = new Person();
        person.setName("岩户铃芽-update");
        person.setId(1);
        int affectedRows = sqlSession.update("PersonMapper.updatePersonNameById", person);
        System.out.println(affectedRows); // 1
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteTest() throws IOException {
        int affectedRows = sqlSession.delete("PersonMapper.deletePersonById","1");
        System.out.println(affectedRows); // 1
        sqlSession.commit();
        sqlSession.close();
    }

}
