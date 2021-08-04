package com.qf.adminrevenueservice;

import com.qf.pojo.Revenue;

import java.util.List;

/**
 * Created by ding on 2020/1/7.
 */
public interface RevenueService {
    List<Revenue> findAll();
    Revenue updateUser(Revenue revenue);
    String deleteById(Integer id);
    Revenue findById(Integer id);
}
