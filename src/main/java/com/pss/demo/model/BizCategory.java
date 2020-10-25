package com.pss.demo.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * biz_category
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizCategory implements Serializable {
    private Integer id;

    private String categoryName;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}