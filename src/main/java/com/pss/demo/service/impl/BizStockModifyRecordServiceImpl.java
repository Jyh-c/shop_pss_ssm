package com.pss.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pss.demo.dao.BizStockModifyRecordDao;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizStockModifyRecord;
import com.pss.demo.service.BizStockModifyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 10:02
 */
@Service
public class BizStockModifyRecordServiceImpl implements BizStockModifyRecordService {

    @Override
    public PageInfo<BizStockModifyRecord> queryAll(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BizStockModifyRecord> bizStockModifyRecords;
        if(keyword == null || "".equals(keyword)){
            bizStockModifyRecords = bizStockModifyRecordDao.selectAll("");
        }else{
            bizStockModifyRecords = bizStockModifyRecordDao.selectAll(keyword);
        }
        return new PageInfo<>(bizStockModifyRecords);
    }

    @Override
    public int addStockModifyRecord(BizStockModifyRecord s) {
        return 0;
    }

    @Autowired
    private BizStockModifyRecordDao bizStockModifyRecordDao;
}
