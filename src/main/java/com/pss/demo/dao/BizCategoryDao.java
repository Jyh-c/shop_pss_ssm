package com.pss.demo.dao;

import com.pss.demo.model.BizCategory;

import java.util.List;

public interface BizCategoryDao {

    List<BizCategory> selectAll(String keyword);

    int deleteByPrimaryKey(Integer id);

    int insert(BizCategory record);

    int insertSelective(BizCategory record);

    BizCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BizCategory record);

    int updateByPrimaryKey(BizCategory record);
}