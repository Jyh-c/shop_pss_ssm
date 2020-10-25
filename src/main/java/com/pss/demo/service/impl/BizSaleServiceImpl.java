package com.pss.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pss.demo.dao.BizSaleDao;
import com.pss.demo.dao.BizStockDao;
import com.pss.demo.dao.BizStockModifyRecordDao;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizSale;
import com.pss.demo.model.BizStock;
import com.pss.demo.model.BizStockModifyRecord;
import com.pss.demo.service.BizSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 10:02
 */
@Service
public class BizSaleServiceImpl implements BizSaleService {
    @Override
    public PageInfo<BizSale> queryAll(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BizSale> bizSales;
        if(keyword == null || "".equals(keyword)){
            bizSales = bizSaleDao.selectAll("");
        }else{
            bizSales = bizSaleDao.selectAll(keyword);
        }
        return new PageInfo<>(bizSales);
    }

    @Override
    public int insertSale(BizSale sale, String barcode, BizStock sto, BizStockModifyRecord smr) {
        int yunalai = bizStockDao.selectByPrimaryKey(barcode).getStockCount();
        int bianhua = sto.getStockCount();
        sto.setStockCount(yunalai + bianhua);
        bizStockDao.updateByPrimaryKeySelective(sto);
        bizStockModifyRecordDao.insertSelective(smr);
        int i = bizSaleDao.insertSelective(sale);
        return i;
    }

    @Autowired
    private BizSaleDao bizSaleDao;
    @Autowired
    private BizStockDao bizStockDao;
    @Autowired
    private BizStockModifyRecordDao bizStockModifyRecordDao;
}
