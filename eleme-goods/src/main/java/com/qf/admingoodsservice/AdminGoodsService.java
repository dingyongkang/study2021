package com.qf.admingoodsservice;

import com.qf.pojo.Goods;

import java.util.List;

/**
 * Created by ding on 2020/1/7.
 */
public interface AdminGoodsService {
    List<Goods> findAll();
    Goods update(Goods goods);
    Goods findById(Integer id);
    String deleteById(Integer id);
}
