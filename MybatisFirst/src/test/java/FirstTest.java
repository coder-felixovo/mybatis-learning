import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pers.felix.mybatisfirst.Role;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
 * @author Felixovo
 * @date 2022/4/25 23:15
 * @desc 测试查询role表全部数据
 */
public class FirstTest {

    @Test
    public void SelectAllTest() throws IOException {
        // 加载核心配置文件 SqlMapConfig.xml
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获得session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行SQL语句
        List<Role> roleList = sqlSession.selectList("RoleMapper.selectAll");

        // 打印结果
        System.out.println(roleList);

        // 释放资源
        sqlSession.close();
    }

}
