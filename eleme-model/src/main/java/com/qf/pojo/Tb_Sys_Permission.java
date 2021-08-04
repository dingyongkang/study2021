package com.qf.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ding on 2020/1/8.
 */
@Data
@Entity
public class Tb_Sys_Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permission_id;
    private String per_name;
    private String menu_name;
    private String menu_type;
    private String menu_url;
    private String menu_code;
    private String per_desc;
    private Integer if_vilid;


}
