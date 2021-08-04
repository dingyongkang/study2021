package com.qf.adminorderservice.adminorderserviceimpl;

import com.qf.adminorderrepository.AdminOrderRepository;
import com.qf.adminorderservice.AdminOrderService;
import com.qf.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by ding on 2020/1/7.
 */
@Service
public class AdminGoodsServiceImpl implements AdminOrderService{
    @Autowired
    private AdminOrderRepository adminOrderRepository;
    @Override
    public List<Order> findAll() {
        return adminOrderRepository.findAll();
    }

    @Override
    public Order update(Order order) {
        return adminOrderRepository.saveAndFlush(order);
    }

    @Override
    public Order findById(Integer id) {
        Optional<Order> byId = adminOrderRepository.findById(id);
        Order order=null;
        if(byId!=null){
            order = byId.get();
        }
        return order;
    }

    @Override
    public String deleteById(Integer id) {
        try {
            adminOrderRepository.deleteById(id);
            return "success";
        }catch (Exception e){
            return "fail";
        }
    }
}
