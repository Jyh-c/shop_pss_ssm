package com.pss.demo.controller;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.*;
import com.pss.demo.response.ResponseEnum;
import com.pss.demo.response.ResponseResult;
import com.pss.demo.service.BizPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/22 14:19
 */
@RestController
public class BizPurchaseController {
    
    @PostMapping("/purchase/all.do")
    public ResponseResult<PageInfo<BizPurchase>> findAll(String keyword, Integer pageNum, Integer pageSize){
        return new ResponseResult<>(ResponseEnum.SUCCESS,bizPurchaseService.queryAll(keyword,pageNum,pageSize));
    }
    
    @PostMapping("/purchase/add.do")
    public ModelAndView add(String bar_code, String product_name, BigDecimal purchase_price,
                            String purchase_date,String pro_date,String exp_date,
                            Integer count,BigDecimal sale_price,Integer supplier_id,Integer category_id){
        ModelAndView mv = new ModelAndView();
        //计算进货总价 ↓
        BigDecimal amount = new BigDecimal(purchase_price.doubleValue() * count);
        BizProduct pro = new BizProduct();
        pro.setBarCode(bar_code); pro.setSupplierId(supplier_id); pro.setCategoryId(category_id);
        pro.setProductName(product_name);pro.setSalePrice(sale_price); pro.setCreateTime(new Date());
        pro.setUpdateTime(new Date()); pro.setDeleted(false);

        BizStock s = new BizStock();
        s.setProductBarCode(bar_code);s.setCreateTime(new Date()); s.setUpdateTime(new Date());
        s.setStockCount(count);s.setDeleted(false);

        BizStockModifyRecord smr = new BizStockModifyRecord();
        smr.setProductBarCode(bar_code); smr.setModifyCount(count); smr.setModifyType("进货"); smr.setCreateTime(new Date());
        smr.setUpdateTime(new Date());smr.setDeleted(false);

        BizPurchase pur = new BizPurchase();
        pur.setProductBarcode(bar_code);pur.setPurchaseDate(purchase_date);pur.setProDate(pro_date);
        pur.setExpDate(exp_date);pur.setPurchasePrice(purchase_price);pur.setCount(count);
        pur.setAmount(amount);pur.setCreateTime(new Date());pur.setUpdateTime(new Date());pur.setDeleted(false);

        bizPurchaseService.addPurchase(pur,bar_code,pro,s,smr);
        mv.setViewName("/view/purchase/purchase_list.jsp");
        return mv;
    }

    @Autowired
    private BizPurchaseService bizPurchaseService;
}
