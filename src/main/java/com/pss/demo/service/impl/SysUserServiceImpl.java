package com.pss.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pss.demo.dao.SysUserDao;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.SysUser;
import com.pss.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 10:03
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Override
    public SysUser login(String loginAccount, String password) {
        return sysUserDao.login(loginAccount,password);
    }

    @Override
    public PageInfo<SysUser> queryAll(String keyword,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> sysUsers;
        if(keyword == null || "".equals(keyword)){
            sysUsers = sysUserDao.selectAll("");
        }else{
            sysUsers = sysUserDao.selectAll(keyword);
        }
        return new PageInfo<>(sysUsers);
    }

    @Override
    public int addUser(SysUser u) {
        u.setCreateTime(new Date());
        u.setUpdateTime(new Date());
        u.setDeleted(false);
        return sysUserDao.insert(u);
    }

    @Override
    public SysUser queryLoginAccount(String loginAccount) {
        return null;
    }

    @Override
    public SysUser queryById(int id) {
        return sysUserDao.selectByPrimaryKey(id);
    }

    @Override
    public int delete(int id) {
        SysUser u = new SysUser();
        u.setId(id);
        u.setUpdateTime(new Date());
        u.setDeleted(true);
        return sysUserDao.updateByPrimaryKeySelective(u);
    }

    @Override
    public int update(SysUser u) {
        u.setUpdateTime(new Date());
        return sysUserDao.updateByPrimaryKeySelective(u);
    }

    @Autowired
    private SysUserDao sysUserDao;
}
