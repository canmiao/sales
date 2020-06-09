package com.business.controller;

import com.business.bean.SaleInfo;
import com.business.common.ResponseBean;
import com.business.service.SaleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * demo
 * @author taoye
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    @Resource
    private SaleInfoService saleInfoService;
    @RequestMapping(value = "/1",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<String> login(String username,String password){
        ResponseBean<String> result = new ResponseBean<>();

        result.setMessage(username+":"+password);
        return result;
    }
}
