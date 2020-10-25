package com.pss.demo.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 20:48
 */
@Data
public class VBizPurchase {

    private Integer id;

    private String supplierName;

    private String productBarcode;

    private String categoryName;

    private String productName;

    private BigDecimal purchasePrice;

    private Integer count;

    private BigDecimal amount;

    private String expDate;

}
