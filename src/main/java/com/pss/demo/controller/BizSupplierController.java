package com.pss.demo.controller;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizSupplier;
import com.pss.demo.response.ResponseEnum;
import com.pss.demo.response.ResponseResult;
import com.pss.demo.service.BizSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 14:42
 */
@RestController
public class BizSupplierController {
    @PostMapping("/supplier/all.do")
    public ResponseResult<PageInfo<BizSupplier>> findAll(String keyword, Integer pageNum, Integer pageSize){
        return new ResponseResult<>(ResponseEnum.SUCCESS,bizSupplierService.queryAll(keyword,pageNum,pageSize));
    }

    @GetMapping("/supplier/find-id.do")
    public ModelAndView findById(Integer id){
        ModelAndView mv = new ModelAndView();
        BizSupplier bizSupplier = bizSupplierService.queryById(id);
        mv.addObject("supplier",bizSupplier);
        mv.setViewName("/view/supplier/supplier_modify.jsp");
        return mv;
    }
    @PostMapping("/supplier/add.do")
    public ModelAndView insert(String supplier_name,String address,String contacts_name,String tel){
        ModelAndView mv = new ModelAndView();
        BizSupplier s = new BizSupplier();
        s.setSupplierName(supplier_name);
        s.setAddress(address);
        s.setContactsName(contacts_name);
        s.setTel(tel);
        bizSupplierService.addSupplier(s);
        mv.setViewName("/view/supplier/supplier_list.jsp");
        return mv;
    }

    @GetMapping("/supplier/delete.do")
    public ModelAndView delete(Integer id){
        ModelAndView mv = new ModelAndView();
        bizSupplierService.delete(id);
        mv.setViewName("/view/supplier/supplier_list.jsp");
        return mv;
    }

    @PostMapping("/supplier/update.do")
    public ModelAndView update(Integer id,String supplier_name,String address,String contacts_name,String tel){
        BizSupplier s = new BizSupplier();
        s.setId(id);
        s.setSupplierName(supplier_name);
        s.setAddress(address);
        s.setContactsName(contacts_name);
        s.setTel(tel);
        ModelAndView mv = new ModelAndView();
        bizSupplierService.update(s);
        mv.setViewName("/view/supplier/supplier_list.jsp");
        return mv;
    }

    @Autowired
    private BizSupplierService bizSupplierService;
}
