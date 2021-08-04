package com.qf.adminservice;

import com.qf.pojo.Tb_Sys_User;

/**
 * Created by ding on 2020/1/8.
 */
public interface SysUserService {
    Tb_Sys_User findByUserName(String username);
}
