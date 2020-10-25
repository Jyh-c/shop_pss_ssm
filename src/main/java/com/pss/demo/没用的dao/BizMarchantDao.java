package com.pss.demo.没用的dao;

import com.pss.demo.model.BizMarchant;

/*！！！！！！！！！！！！！！！1*/

public interface BizMarchantDao {

    int deleteByPrimaryKey(Integer id);

    int insert(BizMarchant record);

    int insertSelective(BizMarchant record);

    BizMarchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BizMarchant record);

    int updateByPrimaryKey(BizMarchant record);
}