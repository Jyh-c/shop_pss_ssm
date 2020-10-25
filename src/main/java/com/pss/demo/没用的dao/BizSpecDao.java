package com.pss.demo.没用的dao;

import com.pss.demo.model.BizSpec;


/*!!!!!!!!!!!!!!!!!!*/

public interface BizSpecDao {

    int deleteByPrimaryKey(Integer id);

    int insert(BizSpec record);

    int insertSelective(BizSpec record);

    BizSpec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BizSpec record);

    int updateByPrimaryKey(BizSpec record);
}