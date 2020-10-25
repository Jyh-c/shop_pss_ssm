package com.pss.demo.dao;

import com.pss.demo.model.BizProduct;

import java.util.List;

public interface BizProductDao {

    List<BizProduct> selectAll(String keyword);

    int deleteByPrimaryKey(Integer id);

    int insert(BizProduct record);

    int insertSelective(BizProduct record);

    BizProduct selectByPrimaryKey(Integer id);

    BizProduct selectByBarCode(String barCode);

    int updateByPrimaryKeySelective(BizProduct record);

    int updateByPrimaryKey(BizProduct record);
}