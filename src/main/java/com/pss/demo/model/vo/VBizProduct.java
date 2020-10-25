package com.pss.demo.model.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 20:45
 */
@Data
public class VBizProduct {

    private Integer id;

    private String barCode;

    private String categoryName;

    private String productName;

    private BigDecimal salePrice;

    private String supplierName;

}
