package pers.felix.mybatisanno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Felix Lee
 * @date 2022/5/22 17:17
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private Date ordertime;
    private double total;
    // 代表当前订单属于哪一个用户
    private User user;
}
