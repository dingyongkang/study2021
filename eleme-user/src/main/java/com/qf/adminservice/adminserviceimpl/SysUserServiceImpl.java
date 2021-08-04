package com.qf.adminservice.adminserviceimpl;

import com.qf.admindao.SysUserDao;
import com.qf.adminservice.SysUserService;
import com.qf.pojo.Tb_Sys_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ding on 2020/1/8.
 */
@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserDao sysUserDao;
    @Override
    public Tb_Sys_User findByUserName(String username) {

        return sysUserDao.findByUserName(username);
    }
}
