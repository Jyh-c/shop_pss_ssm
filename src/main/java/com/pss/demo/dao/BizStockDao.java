package com.pss.demo.dao;

import com.pss.demo.model.BizStock;

import java.util.List;

public interface BizStockDao {

    List<BizStock> selectAll(String keyword);

    int insert(BizStock record);

    int insertSelective(BizStock record);

    BizStock selectByPrimaryKey(String productBarCode);

    int updateByPrimaryKeySelective(BizStock record);

    int updateByPrimaryKey(BizStock record);

}