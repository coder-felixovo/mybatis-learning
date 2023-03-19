import org.junit.Test;
import pers.felix.mybatisdaotraditionnal.dao.RoleDao;
import pers.felix.mybatisdaotraditionnal.dao.impl.RoleDaoImpl;
import pers.felix.mybatisdaotraditionnal.entity.Role;

import java.io.IOException;
import java.util.List;

/*
 * @author Felixovo
 * @date 2022/5/5 19:49
 * @description
 */
public class TraditionalDaoTest {

    @Test
    public void findAllTest() throws IOException {
        RoleDao roleDao = new RoleDaoImpl();
        List<Role> all = roleDao.findAll();
        System.out.println(all);
    }
}
