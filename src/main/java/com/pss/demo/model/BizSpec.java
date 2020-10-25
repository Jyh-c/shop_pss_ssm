package com.pss.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * biz_spec
 * @author 
 */
@Data
public class BizSpec implements Serializable {
    private Integer id;

    private String specName;

    private String specVal;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}