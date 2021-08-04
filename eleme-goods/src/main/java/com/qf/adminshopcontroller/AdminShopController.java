package com.qf.adminshopcontroller;

import com.qf.admingoodsservice.AdminGoodsService;
import com.qf.adminshopservice.AdminShopService;
import com.qf.pojo.Goods;
import com.qf.pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ding on 2020/1/7.
 */
@RestController
@RequestMapping("/admin")
public class AdminShopController {
    @Autowired
    private AdminShopService adminShopService;
    @RequestMapping(value = "/findShop",method = RequestMethod.GET)
    public List<Shop> findAll(){
        return  adminShopService.findAll();
    }
    @RequestMapping(value = "/updateShop",method = RequestMethod.POST)
    public Shop update(@RequestBody Shop shop){
      return  adminShopService.update(shop);
    }
    @RequestMapping(value = "/findOneShop/{id}",method = RequestMethod.GET)
    public Shop findById(@PathVariable("id") Integer id){
        return  adminShopService.findById(id);
    }
    @RequestMapping(value = "/deleteShop/{id}",method = RequestMethod.GET)
    public String deleteById(@PathVariable("id") Integer id){
        return  adminShopService.deleteById(id);
    }
}
