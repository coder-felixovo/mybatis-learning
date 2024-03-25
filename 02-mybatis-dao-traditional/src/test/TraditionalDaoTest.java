import org.junit.Test;
import pers.felix.mybatisdaotraditional.dao.UserDao;
import pers.felix.mybatisdaotraditional.dao.impl.UserDaoImpl;
import pers.felix.mybatisdaotraditional.entity.User;

import java.io.IOException;
import java.util.List;

/*
 * @author Felixovo
 * @date 2022/5/5 19:49
 * @description
 */
public class TraditionalDaoTest {
    @Test
    public void testSelectAll() throws IOException {
        UserDao userDao = new UserDaoImpl();
        List<User> all = userDao.getAllUsers();
        System.out.println(all);
    }
}
