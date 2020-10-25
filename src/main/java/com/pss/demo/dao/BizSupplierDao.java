package com.pss.demo.dao;

import com.pss.demo.model.BizSupplier;

import java.util.List;

public interface BizSupplierDao {

    List<BizSupplier> selectAll(String keyword);

    int deleteByPrimaryKey(Integer id);

    int insert(BizSupplier record);

    int insertSelective(BizSupplier record);

    BizSupplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BizSupplier record);

    int updateByPrimaryKey(BizSupplier record);
}