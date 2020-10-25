package com.pss.demo.service;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizStockModifyRecord;

import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/9/6 19:22
 */
public interface BizStockModifyRecordService {

    /**
     * 查询所有变更记录
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<BizStockModifyRecord> queryAll(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 添加库存变更记录
     * @param s
     * @return
     */
    int addStockModifyRecord(BizStockModifyRecord s);
}
