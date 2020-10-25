package com.pss.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pss.demo.dao.BizCategoryDao;
import com.pss.demo.model.BizCategory;
import com.pss.demo.service.BizCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 10:00
 */
@Service
public class BizCategoryServiceImpl implements BizCategoryService {

    @Override
    public PageInfo<BizCategory> queryAll(String keyword,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BizCategory> bizCategories;
        if(keyword == null || "".equals(keyword)){
            bizCategories = bizCategoryDao.selectAll("");
        }else{
            bizCategories = bizCategoryDao.selectAll(keyword);
        }
        return new PageInfo<>(bizCategories);
    }


    @Override
    public BizCategory queryById(Integer id) {
        return bizCategoryDao.selectByPrimaryKey(id);
    }

    @Override
    public int addBizCategory(BizCategory c) {
        c.setCreateTime(new Date());
        c.setUpdateTime(new Date());
        c.setDeleted(false);
        return bizCategoryDao.insert(c);
    }

    @Override
    public int update(BizCategory c) {
        c.setUpdateTime(new Date());
        return bizCategoryDao.updateByPrimaryKeySelective(c);
    }

    @Override
    public int delete(int id) {
        BizCategory c = new BizCategory();
        c.setId(id);
        c.setUpdateTime(new Date());
        c.setDeleted(true);
        return bizCategoryDao.updateByPrimaryKeySelective(c);
    }

    @Autowired
    private BizCategoryDao bizCategoryDao;
}
