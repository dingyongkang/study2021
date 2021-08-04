package com.qf.admindao;

import com.qf.pojo.Tb_Sys_Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by ding on 2020/1/8.
 */
@Mapper
public interface SysPermissionDao {
    List<Tb_Sys_Permission>findUserPermissionByUserName(String name);
}
