package com.qf.adminshopservice;

import com.qf.pojo.Shop;

import java.util.List;

/**
 * Created by ding on 2020/1/7.
 */
public interface AdminShopService {
    List<Shop> findAll();
    Shop update(Shop shop);
    Shop findById(Integer id);
    String deleteById(Integer id);
}
