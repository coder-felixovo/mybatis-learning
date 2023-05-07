package pers.felix.mybatisdynamic.mapper;


import pers.felix.mybatisdynamic.entity.Employee;

import java.util.List;

/**
 * @author  Felix Lee
 * @date 2022/5/22 14:17
 * @description
 */
public interface EmployeeMapper {
    Employee selectEmployeeByCondition(Employee employee);
    List<Employee> selectEmployeeByIds(List<Integer> ids);
}
