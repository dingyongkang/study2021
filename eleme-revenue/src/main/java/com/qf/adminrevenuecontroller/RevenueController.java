package com.qf.adminrevenuecontroller;

import com.qf.adminrevenueservice.RevenueService;
import com.qf.pojo.Revenue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ding on 2020/1/7.
 */
@RestController
@RequestMapping("/admin")
public class RevenueController {
    @Autowired
    private RevenueService revenueService;
    //查询用户
    @RequestMapping(value = "/findRevenue",method = RequestMethod.GET)
    public List<Revenue> fandAll(){
        List<Revenue> revenues = revenueService.findAll();
        return revenues;
    }
    //修改用户
    @RequestMapping(value = "/updateRevenue",method = RequestMethod.POST)
     public Revenue updateUser(@RequestBody Revenue revenue){
        Revenue revenue1 = revenueService.updateUser(revenue);
        return revenue1;
    }
    //删除用户
    @RequestMapping(value = "/deleteRevenue/{id}",method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") Integer id){
        return revenueService.deleteById(id);
    }
    //查询一个用户
    @RequestMapping(value = "/findOneRevenue/{id}",method = RequestMethod.GET)
    public Revenue findById(@PathVariable("id") Integer id){
        return revenueService.findById(id);
    }
}
