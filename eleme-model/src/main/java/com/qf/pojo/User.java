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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uphoto;
    private String uname;
    private String addr1;
    private String addr2;
    private String addr3;
    private String pass;
    private String tel;
    private String wechat;
    private String card;
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uphoto='" + uphoto + '\'' +
                ", uname='" + uname + '\'' +
                ", addr1='" + addr1 + '\'' +
                ", addr2='" + addr2 + '\'' +
                ", addr3='" + addr3 + '\'' +
                ", pass='" + pass + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
