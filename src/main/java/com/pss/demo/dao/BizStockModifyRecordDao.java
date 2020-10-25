package com.pss.demo.dao;

import com.pss.demo.model.BizStockModifyRecord;

import java.util.List;

public interface BizStockModifyRecordDao {

    List<BizStockModifyRecord> selectAll(String keyword);

    int insert(BizStockModifyRecord record);

    int insertSelective(BizStockModifyRecord record);

}