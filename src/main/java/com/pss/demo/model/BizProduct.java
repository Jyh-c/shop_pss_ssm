package com.pss.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * biz_product
 * @author 
 */
@Data
public class BizProduct implements Serializable {
    private Integer id;

    private String barCode;

    private Integer supplierId;

    private Integer categoryId;

    private String productName;

    private BigDecimal salePrice;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private BizCategory category;

    private BizSupplier supplier;

    private static final long serialVersionUID = 1L;
}