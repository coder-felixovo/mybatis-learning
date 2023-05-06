package pers.felix.mybatisstart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@author Felix Lee
 *@date 2023-03-19 19:57:19
 *@description
 */
@Data
public class Person {
    private int id;
    private String name;
    private int age;
    private String address;
}
