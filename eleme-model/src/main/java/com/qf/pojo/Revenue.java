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
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double shopincome;
    private Double platincome;
    private Double platpercent;
    private Integer rsid;
    private Integer roid;
}
