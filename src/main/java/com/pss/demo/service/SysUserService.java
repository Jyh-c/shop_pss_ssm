package com.pss.demo.service;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.SysUser;

import java.util.List;

/**
 * @author JYH
 */
public interface SysUserService {

	/**
	 * 用户登陆
	 * @param loginAccount
	 * @param password
	 * @return
	 */
	SysUser login(String loginAccount, String password);


	/**
	 * 查询所有用户
	 * @param keyword
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<SysUser> queryAll(String keyword, Integer pageNum, Integer pageSize);

	/**
	 * 用户添加
	 * @param u
	 * @return
	 */
	int addUser(SysUser u);

	/**
	 * 查询用户是否存在
	 * @param loginAccount
	 * @return
	 */
	SysUser queryLoginAccount(String loginAccount);

	/**
	 * 按id查找
	 * @param id 编号
	 * @return
	 */
	SysUser queryById(int id);

	/**
	 * 根据 id 删除
	 * @param id 编号
	 * @return
	 */
	int delete(int id);

	/**
	 * 更新用户
	 * @param u
	 * @return
	 */
	int update(SysUser u);
}
