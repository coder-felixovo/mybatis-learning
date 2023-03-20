
import pers.felix.mybatisanno.entity.Order;
import pers.felix.mybatisanno.entity.Role2;
import pers.felix.mybatisanno.entity.User;
import pers.felix.mybatisanno.mapper.OrderMapper;
import pers.felix.mybatisanno.mapper.RoleMapper2;
import pers.felix.mybatisanno.mapper.UserMapper;
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
 * @date 2022/5/23 15:38
 * @description
 */
public class Test2 {
    private OrderMapper orderMapper;
    private UserMapper userMapper;
    private RoleMapper2 roleMapper2;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
        roleMapper2 = sqlSession.getMapper(RoleMapper2.class);
    }

    // 一对一
    @Test
    public void testSelectOrderAndUser() {
        List<Order> all = orderMapper.findAll();
        for(Order order:all) {
            System.out.println(order);
        }
    }

    // 一对多
    @Test
    public void testSelectUserAndOrder() {
        List<User> all = userMapper.findAllUserAndOrder();
        for(User user:all) {
            System.out.println(user.getUsername());
            List<Order> orderList = user.getOrderList();
            for(Order order:orderList) {
                System.out.println(order);
            }
            System.out.println("----------------------------");
        }
    }

    // 多对多
    @Test
    public void testSelectUserAndRole() {
        List<User> all = userMapper.findAllUserAndRole2();
        for(User user:all) {
            System.out.println(user.getUsername());
            List<Role2> role2List = user.getRoleList();
            for(Role2 role2:role2List) {
                System.out.println(role2);
            }
            System.out.println("---------------------------");
        }
    }
}
