package com.pss.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * biz_purchase
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizPurchase implements Serializable {

    private Integer id;

    private String productBarcode;

    private String purchaseDate;

    private String proDate;

    private String expDate;

    private BigDecimal purchasePrice;

    private Integer count;

    private BigDecimal amount;

    private String receiptImg;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private BizCategory bizCategory;

    private BizSupplier bizSupplier;

    private BizProduct bizProduct;

    private static final long serialVersionUID = 1L;
}