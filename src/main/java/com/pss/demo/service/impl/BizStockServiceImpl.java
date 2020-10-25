package com.pss.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pss.demo.dao.BizStockDao;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizStock;
import com.pss.demo.service.BizStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 10:02
 */
@Service
public class BizStockServiceImpl implements BizStockService {
    @Override
    public PageInfo<BizStock> queryAll(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BizStock> bizStocks;
        if(keyword == null || "".equals(keyword)){
            bizStocks = bizStockDao.selectAll("");
        }else{
            bizStocks = bizStockDao.selectAll(keyword);
        }
        return new PageInfo<>(bizStocks);
    }

    @Override
    public int stockCount(String barcode) {
        if(bizStockDao.selectByPrimaryKey(barcode) == null){
            return -1;
        }else{
            return bizStockDao.selectByPrimaryKey(barcode).getStockCount();
        }
    }

    @Override
    public int addStock(BizStock s) {
        return 0;
    }

    @Override
    public int updateStock(BizStock s) {
        return 0;
    }

    @Autowired
    private BizStockDao bizStockDao;
}
