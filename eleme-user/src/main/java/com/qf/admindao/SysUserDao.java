package com.qf.admindao;

import com.qf.pojo.Tb_Sys_User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by ding on 2020/1/8.
 */
@Mapper
public interface SysUserDao {
    Tb_Sys_User findByUserName(String name);
}
