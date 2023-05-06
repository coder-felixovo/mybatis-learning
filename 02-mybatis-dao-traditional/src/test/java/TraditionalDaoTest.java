import org.junit.Test;
import pers.felix.mybatisdaotraditional.dao.PersonDao;
import pers.felix.mybatisdaotraditional.dao.impl.PersonDaoImpl;
import pers.felix.mybatisdaotraditional.entity.Person;

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
        PersonDao personDao = new PersonDaoImpl();
        List<Person> all = personDao.selectAll();
        System.out.println(all);
    }
}
