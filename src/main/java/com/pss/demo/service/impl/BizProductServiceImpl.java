package com.pss.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pss.demo.dao.BizProductDao;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizProduct;
import com.pss.demo.service.BizProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 10:01
 */
@Service
public class BizProductServiceImpl implements BizProductService {

    @Override
    public PageInfo<BizProduct> queryAll(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BizProduct> bizProducts;
        if(keyword == null || "".equals(keyword)){
            bizProducts = bizProductDao.selectAll("");
        }else{
            bizProducts = bizProductDao.selectAll(keyword);
        }
        return new PageInfo<>(bizProducts);
    }

    @Override
    public BizProduct queryById(Integer id) {
        return bizProductDao.selectByPrimaryKey(id);
    }

    @Override
    public BizProduct queryByBarCode(String barCode) {
        return bizProductDao.selectByBarCode(barCode);
    }


    @Override
    public int addBizProduct(BizProduct p) {
        p.setCreateTime(new Date());
        p.setUpdateTime(new Date());
        p.setDeleted(false);
        return bizProductDao.insert(p);
    }

    @Override
    public int update(BizProduct p) {
        p.setUpdateTime(new Date());
        return bizProductDao.updateByPrimaryKeySelective(p);
    }

    @Override
    public int delete(int id) {
        BizProduct p = new BizProduct();
        p.setId(id);
        p.setUpdateTime(new Date());
        p.setDeleted(true);
        return bizProductDao.updateByPrimaryKeySelective(p);
    }

    @Autowired
    private BizProductDao bizProductDao;

}
