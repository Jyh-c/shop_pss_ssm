package com.pss.demo.没用的dao;

import com.pss.demo.model.SysRoleMenuMap;

/*！！！！！！！！！！！！！！！！！1*/

public interface SysRoleMenuMapDao {

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleMenuMap record);

    int insertSelective(SysRoleMenuMap record);

    SysRoleMenuMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleMenuMap record);

    int updateByPrimaryKey(SysRoleMenuMap record);
}