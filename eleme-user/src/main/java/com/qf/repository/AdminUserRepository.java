package com.qf.repository;

import com.qf.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ding on 2020/1/7.
 */
public interface AdminUserRepository extends JpaRepository<User,Integer>{
}
