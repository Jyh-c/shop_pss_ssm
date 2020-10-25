package com.pss.demo.service;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizCategory;

import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/9/5 16:39
 */
public interface BizCategoryService {

    /**
     * 查询所有类别
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<BizCategory> queryAll(String keyword,Integer pageNum, Integer pageSize);

    /**
     * 查询类别
     * @param id
     * @return 某个类别
     */
    BizCategory queryById(Integer id);

    /**
     * 插入类别
     * @param c 类别
     * @return
     */
    int addBizCategory(BizCategory c);

    /**
     * 更新类别
     * @param c
     * @return
     */
    int update(BizCategory c);

    /**
     * （逻辑）删除类别
     * @param id
     * @return
     */
    int delete(int id);
}
