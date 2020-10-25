package com.pss.demo.dao;

import com.pss.demo.model.SysUser;

import java.util.List;


public interface SysUserDao {

    List<SysUser> selectAll(String keyword);

    SysUser login(String loginAccount, String password);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}