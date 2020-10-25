package com.pss.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * biz_sale
 * @author 
 */
@Data
public class BizSale implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 商品码
     */
    private String productBarCode;

    /**
     * 商品价格
     */
    private BigDecimal salePrice;

    /**
     * 销售时间
     */
    private String saleDate;

    /**
     * 销售数量
     */
    private Integer saleCount;

    private BigDecimal saleAmount;

    private BigDecimal grossProfit;

    private Date createTime;

    private Date updateTime;

    /**
     * 是否删除
     */
    private Boolean deleted;

    private BizProduct bizProduct;

    private static final long serialVersionUID = 1L;
}