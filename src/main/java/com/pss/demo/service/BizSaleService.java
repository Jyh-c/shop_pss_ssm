package com.pss.demo.service;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizSale;
import com.pss.demo.model.BizStock;
import com.pss.demo.model.BizStockModifyRecord;

import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/9/6 23:59
 */
public interface BizSaleService {
    /**
     * 查询所有销售记录
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<BizSale> queryAll(String keyword, Integer pageNum, Integer pageSize);


    /**
     * 插入销售记录
     * @param sale
     * @param barcode
     * @param sto
     * @param smr
     * @return
     */
    int insertSale(BizSale sale, String barcode, BizStock sto, BizStockModifyRecord smr);
}
