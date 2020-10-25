package com.pss.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * biz_product_sepc_map
 * @author 
 */
@Data
public class BizProductSepcMap implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer sepcId;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}