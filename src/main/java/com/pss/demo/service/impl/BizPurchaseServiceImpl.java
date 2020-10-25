package com.pss.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pss.demo.dao.BizProductDao;
import com.pss.demo.dao.BizPurchaseDao;
import com.pss.demo.dao.BizStockDao;
import com.pss.demo.dao.BizStockModifyRecordDao;
import com.pss.demo.model.*;
import com.pss.demo.service.BizPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 10:01
 */
@Service
public class BizPurchaseServiceImpl implements BizPurchaseService {

    @Override
    public PageInfo<BizPurchase> queryAll(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BizPurchase> bizCategories;
        if(keyword == null || "".equals(keyword)){
            bizCategories = bizPurchaseDao.selectAll("");
        }else{
            bizCategories = bizPurchaseDao.selectAll(keyword);
        }
        return new PageInfo<>(bizCategories);
    }

    @Override
    public int addPurchase(BizPurchase pur, String barcode, BizProduct pro, BizStock s, BizStockModifyRecord smr) {
        BizProduct bizProduct = bizProductDao.selectByBarCode(barcode);
        if(bizProduct == null || "".equals(bizProduct.getBarCode())){
            bizProductDao.insertSelective(pro);
            bizStockDao.insertSelective(s);
        }else{
            int yunalai = bizStockDao.selectByPrimaryKey(barcode).getStockCount();
            int bianhua = s.getStockCount();
            s.setStockCount(yunalai + bianhua);
            bizStockDao.updateByPrimaryKeySelective(s);
        }
        bizStockModifyRecordDao.insertSelective(smr);
        int i = bizPurchaseDao.insertSelective(pur);
        return i;
    }

    @Autowired
    private BizPurchaseDao bizPurchaseDao;
    @Autowired
    private BizProductDao bizProductDao;
    @Autowired
    private BizStockDao bizStockDao;
    @Autowired
    private BizStockModifyRecordDao bizStockModifyRecordDao;
}
