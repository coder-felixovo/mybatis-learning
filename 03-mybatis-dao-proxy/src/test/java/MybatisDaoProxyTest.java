import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pers.felix.mybatisdaoproxy.entity.Person;
import pers.felix.mybatisdaoproxy.mapper.PersonMapper;

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
    private PersonMapper personMapper;

    @Before
    public void before() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        personMapper = sqlSession.getMapper(PersonMapper.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testInsert() {
        Person person = new Person();
        person.setId(1);
        person.setName("岩户铃芽");
        person.setAge(17);
        person.setAddress("九州");
        int affectedRows = personMapper.insertPerson(person);
        System.out.println(affectedRows);
    }

    @Test
    public void testDelete() {
        int affectedRows = personMapper.deletePersonById(100);
        System.out.println(affectedRows);
    }

    @Test
    public void testSelect() {
        List<Person> personList = personMapper.selectPeople();
        System.out.println(personList);
    }

    @Test
    public void testUpdate() {
        Person person = new Person();
        person.setId(100);
        person.setName("测试-update");
        int affectedRows = personMapper.updatePersonNameById(person);
        System.out.println(affectedRows);
    }

    @Test
    public void testSelectByMultipleCondition() {
        List<Person> personList = personMapper.selectByMultipleCondition("九州", 17);
        System.out.println(personList);
    }

    @Test
    public void testDynamic() {
        Person person = new Person();
        person.setName("岩户铃芽");
//        person.setAge(17);
//        person.setAddress("九州");
        List<Person> personList = personMapper.selectBySingleCondition(person);
        System.out.println(personList);
    }
}
