package com.pss.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * biz_stock
 * @author 
 */
@Data
public class BizStock implements Serializable {
    private String productBarCode;

    private Integer stockCount;

    private String lockKey;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private BizCategory bizCategory;

    private BizSupplier bizSupplier;

    private BizProduct bizProduct;

    private static final long serialVersionUID = 1L;
}