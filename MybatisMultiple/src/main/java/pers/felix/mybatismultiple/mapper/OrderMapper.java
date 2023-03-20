package pers.felix.mybatismultiple.mapper;

import pers.felix.mybatismultiple.entity.Order;

import java.util.List;

/*
 * author  Felixovo
 * date 2022/5/22 17:24
 */
public interface OrderMapper {
    List<Order> findAll();
}
