package com.pss.demo.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 20:57
 */
@Data
public class VBizSale {

    private String productBarCode;

    private String productName;

    private BigDecimal salePrice;

    private Integer saleCount;

    private BigDecimal saleAmount;

    private String saleDate;

}
