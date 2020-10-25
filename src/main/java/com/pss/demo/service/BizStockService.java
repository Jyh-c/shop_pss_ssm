package com.pss.demo.service;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizStock;

import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/9/6 19:20
 */
public interface BizStockService {

    /**
     * 查询所有库存信息
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<BizStock> queryAll(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 根据条码查询
     * @param barcode
     * @return
     */

    int stockCount(String barcode);

    /**
     * 添加库存信息
     * @param s
     * @return
     */
    int addStock(BizStock s);

    /**
     * 更新库存信息
     * @param s
     * @return
     */
    int updateStock(BizStock s);
}
