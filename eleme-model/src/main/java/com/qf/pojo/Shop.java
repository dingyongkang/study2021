package com.qf.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ding on 2020/1/6.
 */
@Data
@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sname;
    private String spic;
    private String sphone;
    private String saddr;
    private Double goodrate;
    private Integer totalsale;
    private Integer sclassify;
}
