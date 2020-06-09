package com.business.controller;

import com.business.bean.PageResponseBean;
import com.business.bean.SaleInfo;
import com.business.bean.SearchParam;
import com.business.common.CodeConstant;
import com.business.common.MessageConstant;
import com.business.common.ResponseBean;
import com.business.service.SaleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:    销售单控制
* @Author:         ccm
* @CreateDate:     2019/3/27 19:12
*/
@Controller
@RequestMapping(value = "/salelist")
public class SaleInfoController {

    @Resource
    private SaleInfoService saleInfoService;


    /**
     *  查询销售单信息
     * @param searchParam
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<SaleInfo>> selectAllSaleIf(SearchParam searchParam) {
        PageResponseBean<List<SaleInfo>> result = new PageResponseBean<>();
        List<SaleInfo> saleInfos = saleInfoService.selectAllSaleIf(searchParam);
        if (saleInfos.isEmpty()) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(saleInfos);
        return result;

    }


    /**
     * 插入一条销售信息
     * @param saleInfo
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean insertSaleInfo(@RequestBody SaleInfo saleInfo) {
        ResponseBean result = new ResponseBean();
        if (saleInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        saleInfoService.insert(saleInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SALE_INFO_ADDED_SUCCESSFULLY);
        return result;
    }


    /**
     * 根据销售信息中的订单号更新销售信息
     * @param saleInfo
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<SaleInfo> updateInputInfo(@RequestBody SaleInfo saleInfo) {
        ResponseBean<SaleInfo> result = new ResponseBean<>();
        if (saleInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        if (null == saleInfoService.updateSaleInfo(saleInfo)) {
            result.setStatus(CodeConstant.NO_SUCH_SALE_INFO);
            result.setMessage(MessageConstant.NO_SUCH_SALE_INFO);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SALE_INFO_UPDATE_SUCCESSFULLY);
        return result;
    }


    /**
     * 删除一条销售信息
     * @param saleInfo
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<SaleInfo> deleteSaleInfo(@RequestBody SaleInfo saleInfo) {
        ResponseBean<SaleInfo> result = new ResponseBean<>();
        if (saleInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        saleInfoService.deleteSaleInfo(saleInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SALE_INFO_DELETE_SUCCESSFULLY);
        return result;
    }
}
