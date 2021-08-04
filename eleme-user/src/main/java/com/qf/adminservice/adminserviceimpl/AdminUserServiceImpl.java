package com.qf.adminservice.adminserviceimpl;

import com.qf.adminservice.AdminUserService;
import com.qf.pojo.User;
import com.qf.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by ding on 2020/1/7.
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserRepository adminUserRepository;
    @Override
    public List<User> findAll() {
        List<User> user = adminUserRepository.findAll();
        return user;
    }
    @Override
    public User updateUser(User user) {
        return adminUserRepository.saveAndFlush(user);
    }
    @Override
    public String deleteById(Integer id) {
        try{
            adminUserRepository.deleteById(id);
            return "success";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "fail";
    }
    @Override
    public User findById(Integer id) {
        Optional<User> byId = adminUserRepository.findById(id);
        User user=null;
        if(byId!=null){
            user = byId.get();
        }
        return user;
    }
}
