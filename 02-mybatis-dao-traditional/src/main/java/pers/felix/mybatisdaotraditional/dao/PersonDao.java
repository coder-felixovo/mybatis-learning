package pers.felix.mybatisdaotraditional.dao;

import pers.felix.mybatisdaotraditional.entity.Person;

import java.io.IOException;
import java.util.List;

/**
 * @author Felix Lee
 * @date 2022/5/5 19:33
 * @description
 */
public interface PersonDao {
    List<Person> selectAll() throws IOException;
}
