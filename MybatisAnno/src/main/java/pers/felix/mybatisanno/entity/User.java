package pers.felix.mybatisanno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Felixovo
 * @date 2022/5/22 17:19
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private Date birthday;
    // 当前用户具备哪些订单
    private List<Order> orderList;
    // 当前用户具备哪些角色
    private List<Role2> roleList;
}
