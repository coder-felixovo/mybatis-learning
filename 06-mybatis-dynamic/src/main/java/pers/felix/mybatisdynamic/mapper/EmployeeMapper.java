package pers.felix.mybatisdynamic.mapper;


import pers.felix.mybatisdynamic.entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    Employee selectEmployeeByCondition(Employee employee);
    List<Employee> selectEmployeeByIds(List<Integer> ids);
}
