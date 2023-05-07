import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pers.felix.mybatismultiple.entity.Department;
import pers.felix.mybatismultiple.mapper.DepartmentMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-07 11:02:41
 */
public class DepartmentTest {
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private DepartmentMapper departmentMapper;

    @Before
    public void before() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testInsert() {
        Department department = new Department();
        department.setId(100);
        department.setName("测试");
        int affectedRows = departmentMapper.insertDepartment(department);
        System.out.println(affectedRows);
    }

    @Test
    public void testDelete() {
        int affectedRows = departmentMapper.deleteDepartment(100);
        System.out.println(affectedRows);
    }

    @Test
    public void testSelect() {
        List<Department> departmentList = departmentMapper.selectAllDepartment();
        System.out.println(departmentList);
    }

    @Test
    public void testUpdate() {
        Department department = new Department();
        department.setId(100);
        department.setName("测试-update");
        int affectedRows = departmentMapper.updateDepartmentName(department);
        System.out.println(affectedRows);
    }
}
