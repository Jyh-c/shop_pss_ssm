package com.pss.demo.controller;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizProduct;
import com.pss.demo.response.ResponseEnum;
import com.pss.demo.response.ResponseResult;
import com.pss.demo.service.BizProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/22 8:49
 */
@RestController
public class BizProductController {
    @PostMapping("/product/all.do")
    public ResponseResult<PageInfo<BizProduct>> findAll(String keyword, Integer pageNum, Integer pageSize){
        return new ResponseResult<>(ResponseEnum.SUCCESS, bizProductService.queryAll(keyword,pageNum,pageSize));
    }

    @GetMapping("/product/find-id.do")
    public ModelAndView findById(Integer id){
        ModelAndView mv = new ModelAndView();
        BizProduct bizCategory = bizProductService.queryById(id);
        mv.addObject("product",bizCategory);
        mv.setViewName("/view/product/product_modify.jsp");
        return mv;
    }
    @PostMapping("/product/add.do")
    public ModelAndView insert(String bar_code, String product_name, BigDecimal sale_price,Integer supplier_id,Integer category_id){
        ModelAndView mv = new ModelAndView();
        BizProduct p = new BizProduct();
        p.setBarCode(bar_code);
        p.setProductName(product_name);
        p.setSalePrice(sale_price);
        p.setSupplierId(supplier_id);
        p.setCategoryId(category_id);
        bizProductService.addBizProduct(p);
        mv.setViewName("/view/product/product_list.jsp");
        return mv;
    }

    @GetMapping("/product/delete.do")
    public ModelAndView delete(Integer id){
        ModelAndView mv = new ModelAndView();
        bizProductService.delete(id);
        mv.setViewName("/view/product/product_list.jsp");
        return mv;
    }

    @PostMapping("/product/update.do")
    public ModelAndView update(String bar_code, String product_name, BigDecimal sale_price,Integer supplier_id,Integer category_id){
        ModelAndView mv = new ModelAndView();
        BizProduct p = new BizProduct();
        p.setBarCode(bar_code);
        p.setProductName(product_name);
        p.setSalePrice(sale_price);
        p.setSupplierId(supplier_id);
        p.setCategoryId(category_id);
        bizProductService.update(p);
        mv.setViewName("/view/product/product_list.jsp");
        return mv;
    }

    @Autowired
    private BizProductService bizProductService;
}
