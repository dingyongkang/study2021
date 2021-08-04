package com.qf.admingoodsservice.admingoodsserviceimpl;

import com.qf.admingoodsrepository.AdminGoodsRepository;
import com.qf.admingoodsservice.AdminGoodsService;
import com.qf.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by ding on 2020/1/7.
 */
@Service
public class AdminGoodsServiceImpl implements AdminGoodsService{
    @Autowired
    private AdminGoodsRepository adminGoodsRepository;
    @Override
    public List<Goods> findAll() {
        return adminGoodsRepository.findAll();
    }

    @Override
    public Goods update(Goods goods) {
        return adminGoodsRepository.saveAndFlush(goods);
    }

    @Override
    public Goods findById(Integer id) {
        Optional<Goods> byId = adminGoodsRepository.findById(id);
        Goods goods=null;
        if(byId!=null){
            goods = byId.get();
        }
        return goods;
    }

    @Override
    public String deleteById(Integer id) {
        try {
            adminGoodsRepository.deleteById(id);
            return "success";
        }catch (Exception e){
            return "fail";
        }
    }
}
