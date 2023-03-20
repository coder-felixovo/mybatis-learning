package pers.felix.mybatismultiple.entity;

import lombok.Data;

import javax.management.relation.Role;
import java.util.Date;
import java.util.List;

/*
 * @author Felixovo
 * @date 2022/5/22 17:19
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private Date birthday;
    // 当前用户具备哪些订单
    private List<Order> orderList;
    // 当前用户具备哪些角色
    private List<Role> roleList;
}
