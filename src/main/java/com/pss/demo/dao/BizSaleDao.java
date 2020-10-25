package com.pss.demo.dao;

import com.pss.demo.model.BizSale;

import java.util.List;

public interface BizSaleDao {

    List<BizSale> selectAll(String keyword);

    int insert(BizSale record);

    int insertSelective(BizSale record);

}