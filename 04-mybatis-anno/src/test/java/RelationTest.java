import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pers.felix.mybatisanno.entity.Department;
import pers.felix.mybatisanno.entity.Employee;
import pers.felix.mybatisanno.mapper.DepartmentMapper;
import pers.felix.mybatisanno.mapper.EmployeeMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author felixovo
 * @date 2022/5/23 15:05
 */
public class RelationTest {

    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private EmployeeMapper employeeMapper;
    private DepartmentMapper departmentMapper;

    @Before
    public void before() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
    }

    @After
    public void after() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testOneToOne() {
        Employee employee = employeeMapper.selectEmployeeByIdWithDepartment(1);
        System.out.println(employee);
        System.out.println(employee.getDepartment());
    }

    @Test
    public void testOneToMany() {
        Department department = departmentMapper.selectDepartmentByIdWithEmployee(1);
        System.out.println(department);
        System.out.println(department.getEmployeeList());
    }

    @Test
    public void testManyToMany() {
        List<Employee> employeeList = employeeMapper.selectAllEmployeeWithRole();
        for (Employee employee : employeeList) {
            System.out.println(employee);
            System.out.println(employee.getRoleList());
            System.out.println("----------");
        }
    }

}
