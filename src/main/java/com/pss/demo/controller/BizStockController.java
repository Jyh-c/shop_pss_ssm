package com.pss.demo.controller;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizStock;
import com.pss.demo.response.ResponseEnum;
import com.pss.demo.response.ResponseResult;
import com.pss.demo.service.BizStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/22 11:33
 */
@RestController
public class BizStockController {

    @PostMapping("/stock/all.do")
    public ResponseResult<PageInfo<BizStock>> findAll(String keyword, Integer pageNum, Integer pageSize){
        return new ResponseResult<>(ResponseEnum.SUCCESS,bizStockService.queryAll(keyword,pageNum,pageSize));
    }

    @Autowired
    private BizStockService bizStockService;
}
