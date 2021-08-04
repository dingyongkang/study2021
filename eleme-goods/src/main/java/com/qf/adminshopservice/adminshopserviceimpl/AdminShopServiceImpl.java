package com.qf.adminshopservice.adminshopserviceimpl;

import com.qf.admingoodsrepository.AdminGoodsRepository;
import com.qf.admingoodsservice.AdminGoodsService;
import com.qf.adminshoprepository.AdminShopRepository;
import com.qf.adminshopservice.AdminShopService;
import com.qf.pojo.Goods;
import com.qf.pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by ding on 2020/1/7.
 */
@Service
public class AdminShopServiceImpl implements AdminShopService{
    @Autowired
    private AdminShopRepository adminShopRepository;
    @Override
    public List<Shop> findAll() {
        return adminShopRepository.findAll();
    }

    @Override
    public Shop update(Shop shop) {
        return adminShopRepository.saveAndFlush(shop);
    }

    @Override
    public Shop findById(Integer id) {
        Optional<Shop> byId = adminShopRepository.findById(id);
        Shop shop=null;
        if(byId!=null){
            shop = byId.get();
        }
        return shop;
    }

    @Override
    public String deleteById(Integer id) {
        try {
            adminShopRepository.deleteById(id);
            return "success";
        }catch (Exception e){
            return "fail";
        }
    }
}
