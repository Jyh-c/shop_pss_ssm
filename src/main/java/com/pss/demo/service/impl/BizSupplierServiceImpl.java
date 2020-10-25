package com.pss.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pss.demo.dao.BizSupplierDao;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizSupplier;
import com.pss.demo.service.BizSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 10:03
 */
@Service
public class BizSupplierServiceImpl implements BizSupplierService {
    @Override
    public PageInfo<BizSupplier> queryAll(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BizSupplier> bizSuppliers;
        if(keyword == null || "".equals(keyword)){
            bizSuppliers = bizSupplierDao.selectAll(null);
        }else{
            bizSuppliers = bizSupplierDao.selectAll(keyword);
        }
        return new PageInfo<>(bizSuppliers);
    }

    @Override
    public BizSupplier queryById(int id) {
        return bizSupplierDao.selectByPrimaryKey(id);
    }

    @Override
    public int addSupplier(BizSupplier s) {
        s.setCreateTime(new Date());
        s.setUpdateTime(new Date());
        s.setDeleted(false);
        return bizSupplierDao.insert(s);
    }

    @Override
    public int update(BizSupplier s) {
        s.setUpdateTime(new Date());
        return bizSupplierDao.updateByPrimaryKeySelective(s);
    }

    @Override
    public int delete(int id) {
        BizSupplier s = new BizSupplier();
        s.setId(id);
        s.setUpdateTime(new Date());
        s.setDeleted(true);
        return bizSupplierDao.updateByPrimaryKeySelective(s);
    }

    @Autowired
    private BizSupplierDao bizSupplierDao;

}
