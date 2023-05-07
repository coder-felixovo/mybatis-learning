package pers.felix.mybatisdaoproxy.mapper;

import pers.felix.mybatisdaoproxy.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {
    // 查询全部人员
    List<Person> selectPeople();

    // 根据id修改人员名字
    int updatePersonNameById(Person person);

    // 根据id删除人员
    int deletePersonById(int id);

    // 新增人员
    int insertPerson(Person person);

    // 多条件查询
    List<Person> selectByMultipleCondition(@Param("address") String address, @Param("age") int age);

    // 单条件动态查询
    List<Person> selectBySingleCondition(Person person);
}
