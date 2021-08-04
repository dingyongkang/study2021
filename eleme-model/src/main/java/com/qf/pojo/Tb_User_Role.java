package com.qf.pojo;

import lombok.Data;
import org.hibernate.graph.spi.GraphNodeImplementor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ding on 2020/1/8.
 */
@Data
@Entity
public class Tb_User_Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private Integer role_id;
}
