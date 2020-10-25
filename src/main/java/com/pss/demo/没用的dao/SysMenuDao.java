package com.pss.demo.没用的dao;

import com.pss.demo.model.SysMenu;

/*!!!!!!!!!!!!!!!!!!!!!!!!!!1*/

public interface SysMenuDao {

    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}