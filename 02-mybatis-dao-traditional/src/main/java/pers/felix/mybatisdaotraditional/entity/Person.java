package pers.felix.mybatisdaotraditional.entity;

import lombok.Data;

/**
 * @author Felix Lee
 * @date 2022/5/5 19:33
 * @description
 */
@Data
public class Person {
    private int id;
    private String name;
    private int age;
    private String address;
}