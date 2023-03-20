package pers.felix.mybatismultiple.entity;

import lombok.Data;

import java.util.Date;

/*
 * @author Felixovo
 * @date 2022/5/22 17:17
 */
@Data
public class Order {
    private int id;
    private Date ordertime;
    private double total;
    // 代表当前订单属于哪一个用户
    private User user;
}
