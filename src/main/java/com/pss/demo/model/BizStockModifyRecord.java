package com.pss.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * biz_stock_modify_record
 * @author 
 */
@Data
public class BizStockModifyRecord implements Serializable {
    private Integer id;

    private String productBarCode;

    private Integer operatorId;

    private Integer modifyCount;

    private String modifyType;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private BizCategory bizCategory;

    private BizProduct bizProduct;


    private static final long serialVersionUID = 1L;
}