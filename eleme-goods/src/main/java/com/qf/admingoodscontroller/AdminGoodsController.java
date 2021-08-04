package com.qf.admingoodscontroller;

import com.qf.admingoodsservice.AdminGoodsService;
import com.qf.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ding on 2020/1/7.
 */
@RestController
@RequestMapping("/admin")
public class AdminGoodsController {
    @Autowired
    private AdminGoodsService adminGoodsService;
    @RequestMapping(value = "/findGoods",method = RequestMethod.GET)
    public List<Goods> findAll(){
        return  adminGoodsService.findAll();
    }
    @RequestMapping(value = "/updateGoods",method = RequestMethod.POST)
    public Goods update(@RequestBody Goods goods){
      return  adminGoodsService.update(goods);
    }
    @RequestMapping(value = "/findOneGoods/{id}",method = RequestMethod.GET)
    public Goods findById(@PathVariable("id") Integer id){
        return  adminGoodsService.findById(id);
    }
    @RequestMapping(value = "/deleteGoods/{id}",method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") Integer id){
        return  adminGoodsService.deleteById(id);
    }
}
