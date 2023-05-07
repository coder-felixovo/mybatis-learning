import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pers.felix.mybatisanno.entity.Department;
import pers.felix.mybatisanno.mapper.DepartmentMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author felixovo
 * @date 2023-05-06 20:46:10
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
        department.setId(1);
        department.setName("财务部");
        int affectedRows = departmentMapper.insertDepartment(department);
        System.out.println(affectedRows);
    }

    @Test
    public void testDelete() {
        int affectedRows = departmentMapper.deleteDepartment(1);
        System.out.println(affectedRows);
    }

    @Test
    public void testSelect() {
        List<Department> departmentList = departmentMapper.selectAllDepartment();
        System.out.println(departmentList.toString());
    }

    @Test
    public void testUpdate() {
        Department department = new Department();
        department.setId(1);
        department.setName("财务部-update");
        int affectedRows = departmentMapper.updateDepartmentName(department);
        System.out.println(affectedRows);
    }
}
