package com.pss.demo.service;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizProduct;

import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/9/5 18:31
 */
public interface BizProductService {

    /**
     * 查询所有商品
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<BizProduct> queryAll(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 查询商品id
     * @param id
     * @return 某个商品
     */
    BizProduct queryById(Integer id);

    /**
     * 根据条码查询
     * @param barCode
     * @return
     */
    BizProduct queryByBarCode(String barCode);

    /**
     * 插入商品
     * @param p 商品
     * @return 
     *
     */
    int addBizProduct(BizProduct p);

    /**
     * 更新商品
     * @param p
     * @return
     */
    int update(BizProduct p);

    /**
     * （逻辑）删除商品
     * @param id
     * @return
     */
    int delete(int id);
    
}
