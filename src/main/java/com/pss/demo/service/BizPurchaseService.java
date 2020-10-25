package com.pss.demo.service;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.*;

import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/9/6 12:49
 */
public interface BizPurchaseService {

    /**
     * 查询所有进货记录
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<BizPurchase> queryAll(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 插入进货记录
     * @param pro 进货记录
     * @param barcode 商品条码
     * @param s
     * @param smr
     * @return
     */
    int addPurchase(BizPurchase pur, String barcode, BizProduct pro, BizStock s, BizStockModifyRecord smr);

}
