package com.business.controller;

import com.business.bean.PageResponseBean;
import com.business.bean.SaleInfo;
import com.business.bean.SaleRefundInfo;
import com.business.bean.SearchParam;
import com.business.common.CodeConstant;
import com.business.common.MessageConstant;
import com.business.common.ResponseBean;
import com.business.service.SaleRefundInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:    销售退货控制
* @Author:         ccm
* @CreateDate:     2019/3/26 17:05
*/
@Controller
@RequestMapping(value = "/sales/refund")
public class SaleRefundInfoController {

    @Resource
    private SaleRefundInfoService saleRefundInfoService;


    /**
     *  查询销售退货单信息
     * @param searchParam
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<SaleRefundInfo>> selectSaleRefundInfoById(SearchParam searchParam) {
        PageResponseBean<List<SaleRefundInfo>> result = new PageResponseBean<>();
        List<SaleRefundInfo> saleRefundInfos = saleRefundInfoService.selectAllSaleRefund(searchParam);
        if (saleRefundInfos == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_SALE_REFUND_INFORMATION);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(saleRefundInfos);
        return result;
    }


    /**
     * 插入一条销售退货信息
     * @param saleRefundInfo
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<SaleRefundInfo> insertSaleRefundInfo(@RequestBody SaleRefundInfo saleRefundInfo) {
        ResponseBean<SaleRefundInfo> result = new ResponseBean<>();
        if (saleRefundInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        saleRefundInfoService.insetSaleRefundInfo(saleRefundInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SALE_REFUND_INFO_ADDED_SUCCESSFULLY);
        return result;
    }


    /**
     * 根据销售退货信息中的订单号更新销售退货信息
     * @param saleRefundInfo
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<SaleRefundInfo> updateSaleRefundInfo(@RequestBody SaleRefundInfo saleRefundInfo) {
        ResponseBean<SaleRefundInfo> result = new ResponseBean<>();
        if (saleRefundInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        if (null == saleRefundInfoService.updateSaleRefundInfo(saleRefundInfo)) {
            result.setStatus(CodeConstant.NO_SUCH_SALE_REFUND_INFO);
            result.setMessage(MessageConstant.NO_SUCH_SALE_REFUND_INFO);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SALE_REFUND_INFO_UPDATE_SUCCESSFULLY);
        return result;
    }


    /**
     * 删除一条销售退货信息
     * @param saleRefundInfo
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<SaleRefundInfo> deleteSaleRefundInfo(@RequestBody SaleRefundInfo saleRefundInfo) {
        ResponseBean<SaleRefundInfo> result = new ResponseBean<>();
        if (saleRefundInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        saleRefundInfoService.deleteSaleRefundInfo(saleRefundInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SALE_REFUND_INFO_DELETE_SUCCESSFULLY);
        return result;
    }


    /**
     * 查询所有销售退货信息
     */
    @RequestMapping(value = "/gain", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<SaleRefundInfo>> selectAllSaleRefundIf(SearchParam searchParam) {
        PageResponseBean<List<SaleRefundInfo>> result = new PageResponseBean<>();
        List<SaleRefundInfo> saleRefundInfos = saleRefundInfoService.selectAllSaleRefund(searchParam);
        if (saleRefundInfos.isEmpty()) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(saleRefundInfos);
        return result;
    }
}
