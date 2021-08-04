package com.qf.adminrevenuerepository;

import com.qf.pojo.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ding on 2020/1/7.
 */
public interface AdminRevenueRepository extends JpaRepository<Revenue,Integer>{
}
