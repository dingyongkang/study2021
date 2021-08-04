package com.qf.adminorderrepository;

import com.qf.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ding on 2020/1/7.
 */
public interface AdminOrderRepository extends JpaRepository<Order,Integer>{
}
