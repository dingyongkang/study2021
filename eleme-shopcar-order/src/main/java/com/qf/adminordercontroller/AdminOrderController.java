package com.qf.adminordercontroller;

import com.qf.adminorderservice.AdminOrderService;
import com.qf.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ding on 2020/1/7.
 */
@RestController
@RequestMapping("/admin")
public class AdminOrderController {
    @Autowired
    private AdminOrderService adminOrderService;
    @RequestMapping(value = "/findOrder",method = RequestMethod.GET)
    public List<Order> findAll(){
        return  adminOrderService.findAll();
    }
    @RequestMapping(value = "/updateOrder",method = RequestMethod.POST)
    public Order update(@RequestBody Order order){
      return  adminOrderService.update(order);
    }
    @RequestMapping(value = "/findOneOrder/{id}",method = RequestMethod.GET)
    public Order findById(@PathVariable("id") Integer id){
        return  adminOrderService.findById(id);
    }
    @RequestMapping(value = "/deleteGoods/{id}",method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") Integer id){
        return  adminOrderService.deleteById(id);
    }
}
