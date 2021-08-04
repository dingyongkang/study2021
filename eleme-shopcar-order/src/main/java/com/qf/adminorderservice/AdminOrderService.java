package com.qf.adminorderservice;

import com.qf.pojo.Goods;
import com.qf.pojo.Order;

import java.util.List;

/**
 * Created by ding on 2020/1/7.
 */
public interface AdminOrderService {
    List<Order> findAll();
    Order update(Order order);
    Order findById(Integer id);
    String deleteById(Integer id);
}
