package com.pss.demo.没用的dao;

import com.pss.demo.model.SysRole;

import java.util.List;

public interface SysRoleDao {

    List<SysRole> selectAll();

    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}