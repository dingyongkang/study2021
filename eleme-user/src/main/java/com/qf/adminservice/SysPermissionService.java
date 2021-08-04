package com.qf.adminservice;

import com.qf.pojo.Tb_Sys_Permission;

import java.util.List;

/**
 * Created by ding on 2020/1/8.
 */
public interface SysPermissionService {
    List<Tb_Sys_Permission> findUserPermissionByUserName(String name);
}
