package com.pss.demo.service;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizSupplier;

import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/9/5 18:06
 */
public interface BizSupplierService {
    /**
     * 查询所有供应商
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     * @return
     */
    PageInfo<BizSupplier> queryAll(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 查询供应商
     * @param id 供应商条码
     * @return 某个供应商
     */
    BizSupplier queryById(int id);

    /**
     * 插入供应商
     * @param s 供应商
     * @return 
     */
    int addSupplier(BizSupplier s);

    /**
     * 更新供应商
     * @param s
     * @return
     */
    int update(BizSupplier s);

    /**
     * （逻辑）删除供应商
     * @param id
     * @return
     */
    int delete(int id);
}
