import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pers.felix.mybatisdaoproxy.mapper.RoleMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Felix Lee
 * @date 2023-03-19 23:09:53
 * @description
 */
public class DeleteTest {
    @Test
    public void deleteByIdTest () throws IOException {
        String id = "6";
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        int result = roleMapper.deleteById(id);
        System.out.println(result); // 1
        sqlSession.close();
    }
}
