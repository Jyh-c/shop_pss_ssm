package com.pss.demo.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 21:00
 */
@Data
public class VBizStockModifyRecord {

    private String productBarCode;

    private String categoryName;

    private String productName;

    private Integer modifyCount;

    private Date modifyDate;

}
