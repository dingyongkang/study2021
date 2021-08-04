package com.qf.adminrevenueservice.adminrevenueserviceimpl;

import com.qf.adminrevenuerepository.AdminRevenueRepository;
import com.qf.adminrevenueservice.RevenueService;
import com.qf.pojo.Revenue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by ding on 2020/1/7.
 */
@Service
public class UserServiceImpl implements RevenueService{
    @Autowired
    private AdminRevenueRepository adminRevenueRepository;
    @Override
    public List<Revenue> findAll() {
        List<Revenue> revenues = adminRevenueRepository.findAll();
        return revenues;
    }
    @Override
    public Revenue updateUser(Revenue revenue) {
        return adminRevenueRepository.saveAndFlush(revenue);
    }
    @Override
    public String deleteById(Integer id) {
        try{
            adminRevenueRepository.deleteById(id);
            return "success";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "fail";
    }
    @Override
    public Revenue findById(Integer id) {
        Optional<Revenue> byId = adminRevenueRepository.findById(id);
        Revenue revenue=null;
        if(byId!=null){
            revenue = byId.get();
        }
        return revenue;
    }
}
