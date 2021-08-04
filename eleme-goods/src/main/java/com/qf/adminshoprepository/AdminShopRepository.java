package com.qf.adminshoprepository;

import com.qf.pojo.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ding on 2020/1/7.
 */
public interface AdminShopRepository extends JpaRepository<Shop,Integer>{
}
