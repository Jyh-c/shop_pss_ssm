package com.pss.demo.controller;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizCategory;
import com.pss.demo.response.ResponseEnum;
import com.pss.demo.response.ResponseResult;
import com.pss.demo.service.BizCategoryService;
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
public class BizCategoryController {

    @PostMapping("/category/all.do")
    public ResponseResult<PageInfo<BizCategory>> findAll(String keyword, Integer pageNum, Integer pageSize){
        return new ResponseResult<>(ResponseEnum.SUCCESS,bizCategoryService.queryAll(keyword,pageNum,pageSize));
    }

    @GetMapping("/category/find-id.do")
    public ModelAndView findById(Integer id){
        ModelAndView mv = new ModelAndView();
        BizCategory bizCategory = bizCategoryService.queryById(id);
        mv.addObject("category",bizCategory);
        mv.setViewName("/view/category/category_modify.jsp");
        return mv;
    }
    @PostMapping("/category/add.do")
    public ModelAndView insert(String category_name){
        ModelAndView mv = new ModelAndView();
        BizCategory c = new BizCategory();
        c.setCategoryName(category_name);
        bizCategoryService.addBizCategory(c);
        mv.setViewName("/view/category/category_list.jsp");
        return mv;
    }

    @GetMapping("/category/delete.do")
    public ModelAndView delete(Integer id){
        ModelAndView mv = new ModelAndView();
        bizCategoryService.delete(id);
        mv.setViewName("/view/category/category_list.jsp");
        return mv;
    }

    @PostMapping("/category/update.do")
    public ModelAndView update(Integer id,String category_name){
        BizCategory c = new BizCategory();
        c.setId(id);
        c.setCategoryName(category_name);
        ModelAndView mv = new ModelAndView();
        bizCategoryService.update(c);
        mv.setViewName("/view/category/category_list.jsp");
        return mv;
    }

    @Autowired
    private BizCategoryService bizCategoryService;

}
