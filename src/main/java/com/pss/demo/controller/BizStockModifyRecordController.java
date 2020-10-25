package com.pss.demo.controller;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.BizStockModifyRecord;
import com.pss.demo.response.ResponseEnum;
import com.pss.demo.response.ResponseResult;
import com.pss.demo.service.BizStockModifyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/22 12:01
 */
@RestController
public class BizStockModifyRecordController {

    @PostMapping("/stockmodifyrecord/all.do")
    public ResponseResult<PageInfo<BizStockModifyRecord>> findAll(String keyword, Integer pageNum, Integer pageSize){
        return new ResponseResult<>(ResponseEnum.SUCCESS,bizStockModifyRecordService.queryAll(keyword,pageNum,pageSize));
    }

    @Autowired
    private BizStockModifyRecordService bizStockModifyRecordService;
}
