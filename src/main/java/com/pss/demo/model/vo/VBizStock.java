package com.pss.demo.model.vo;

import lombok.Data;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 20:59
 */
@Data
public class VBizStock {

    private String productBarCode;

    private String categoryName;

    private String productName;

    private Integer stockCount;

    private String supplierName;

    private String contactsName;

    private String supplierTel;

}
