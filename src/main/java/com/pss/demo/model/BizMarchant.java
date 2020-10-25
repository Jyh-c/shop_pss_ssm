package com.pss.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * biz_marchant
 * @author 
 */
@Data
public class BizMarchant implements Serializable {
    private Integer id;

    private String merchantName;

    private String tel;

    private String address;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}