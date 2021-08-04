package com.qf.adminservice.adminserviceimpl;

import com.qf.admindao.SysPermissionDao;
import com.qf.adminservice.SysPermissionService;
import com.qf.pojo.Tb_Sys_Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ding on 2020/1/8.
 */
@Service
public class SysPermissionImpl implements SysPermissionService{
    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public List<Tb_Sys_Permission> findUserPermissionByUserName(String name) {
        return sysPermissionDao.findUserPermissionByUserName(name);
    }
}
