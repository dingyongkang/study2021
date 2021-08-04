package com.qf.admingoodsrepository;

import com.qf.pojo.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ding on 2020/1/7.
 */
public interface AdminGoodsRepository extends JpaRepository<Goods,Integer>{
}
