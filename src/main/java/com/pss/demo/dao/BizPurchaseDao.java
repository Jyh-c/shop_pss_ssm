package com.pss.demo.dao;

import com.pss.demo.model.BizPurchase;

import java.util.List;

public interface BizPurchaseDao {

    List<BizPurchase> selectAll(String keyword);

    int insert(BizPurchase record);

    int insertSelective(BizPurchase record);

}