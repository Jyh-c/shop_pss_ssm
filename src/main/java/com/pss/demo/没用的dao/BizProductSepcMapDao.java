package com.pss.demo.没用的dao;

import com.pss.demo.model.BizProductSepcMap;


/*!!!!!!!!!!!!!!!!!!*/

public interface BizProductSepcMapDao {

    int deleteByPrimaryKey(Integer id);

    int insert(BizProductSepcMap record);

    int insertSelective(BizProductSepcMap record);

    BizProductSepcMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BizProductSepcMap record);

    int updateByPrimaryKey(BizProductSepcMap record);
}