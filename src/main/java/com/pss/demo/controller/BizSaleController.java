package com.pss.demo.controller;

import com.github.pagehelper.PageInfo;
import com.pss.demo.dao.BizStockDao;
import com.pss.demo.model.BizCategory;
import com.pss.demo.model.BizSale;
import com.pss.demo.model.BizStock;
import com.pss.demo.model.BizStockModifyRecord;
import com.pss.demo.response.ResponseEnum;
import com.pss.demo.response.ResponseResult;
import com.pss.demo.service.BizSaleService;
import com.pss.demo.service.BizStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.parsers.SAXParser;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/22 13:47
 */
@RestController
public class BizSaleController {

    @PostMapping("/sale/all.do")
    public ResponseResult<PageInfo<BizSale>> findAll(String keyword, Integer pageNum, Integer pageSize){
        return new ResponseResult<>(ResponseEnum.SUCCESS,bizSaleService.queryAll(keyword,pageNum,pageSize));
    }

    @PostMapping("/sale/add.do")
    public ModelAndView add(String product_bar_code, BigDecimal sale_price,String sale_date,
                            Integer sale_count){
        ModelAndView mv = new ModelAndView();
        double amount = sale_price.doubleValue()*sale_count;
        int stockCount = bizStockService.stockCount(product_bar_code);
        if(stockCount == -1){
            mv.addObject("saleError","<script>alert('商品不存在！！')</script>");
            mv.setViewName("/view/sale/do_sale.jsp");
        }else if( stockCount <= 0 || (stockCount - sale_count) < 0 ){
            mv.addObject("saleError","<script>alert('库存已不足！！')</script>");
            mv.setViewName("/view/sale/do_sale.jsp");
        }else{
            BizStock sto = new BizStock();
            sto.setProductBarCode(product_bar_code); sto.setUpdateTime(new Date()); sto.setCreateTime(new Date());
            sto.setStockCount(-1 * sale_count);

            BizStockModifyRecord smr = new BizStockModifyRecord();
            smr.setProductBarCode(product_bar_code); smr.setModifyCount(sale_count); smr.setModifyType("销售"); smr.setCreateTime(new Date());
            smr.setUpdateTime(new Date());smr.setDeleted(false);

            BizSale sale = new BizSale();
            sale.setProductBarCode(product_bar_code);sale.setSalePrice(sale_price);sale.setSaleDate(sale_date);
            sale.setSaleCount(sale_count);sale.setSaleAmount(new BigDecimal(amount));
            sale.setCreateTime(new Date());sale.setUpdateTime(new Date());sale.setDeleted(false);
            bizSaleService.insertSale(sale,product_bar_code,sto,smr);
            mv.setViewName("/view/sale/sale_list.jsp");
        }
        return mv;
    }

    @Autowired
    private BizSaleService bizSaleService;
    @Autowired
    private BizStockService bizStockService;

}
