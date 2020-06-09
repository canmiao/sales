package com.business.controller;

import com.business.bean.InventoryInfo;
import com.business.bean.PageResponseBean;
import com.business.bean.SaleInfo;
import com.business.common.CodeConstant;
import com.business.common.InventoryConstant;
import com.business.common.MessageConstant;
import com.business.common.ResponseBean;
import com.business.dto.OutputInfoDTO;
import com.business.dto.PurchaseDTO;
import com.business.mapper.InventoryInfoMapper;
import com.business.service.InventoryInfoService;
import com.business.service.SaleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ccm
 * @Description: salesperson controller
 * @Date: 17:48 2018/03/04
 */
@Controller
@RequestMapping(value = "/sales")
public class SalerController {
    private final static Logger logger = LoggerFactory.getLogger(SalerController.class);

    @Resource
    InventoryInfoMapper inventoryInfoMapper;

    @Resource
    SaleInfoService saleInfoService;

    @Resource
    InventoryInfoService inventoryInfoService;


    /**
     * 接收销售员填写好的订单
     */
    @RequestMapping(value = "/sale", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean ReceiveSaleOrder(@RequestBody SaleInfo saleInfo) {
        ResponseBean result = new ResponseBean();
        if (saleInfo == null) {
            logger.info("SalerController.ReceiveSaleOrder ==> saleInfo is null");
            result.setStatus(CodeConstant.NOT_EXIST);
            result.setMessage(MessageConstant.PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        saleInfoService.insert(saleInfo);
        result.setStatus(InventoryConstant.DEFAYLT_SALE_STATUS);
        result.setMessage(MessageConstant.DEFAYLT_SALE_STATUS);
        result.setData(saleInfo);
        return result;
    }


    /**
     * 根据传入的销售单信息自动判断库存是否有足够的货
     */
    @RequestMapping(value = "/sys/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean CheckInventoryIsEnough(@RequestBody SaleInfo saleInfo) {
        ResponseBean result = new ResponseBean();
        if (saleInfo == null) {
            logger.info("SalerController.CheckInventoryIsEnough ==> saleInfo is null");
            result.setStatus(CodeConstant.NOT_EXIST);
            result.setMessage(MessageConstant.PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        //无库存时bo = "false"
        Boolean bo = inventoryInfoService.checkByProductName(saleInfo.getProduct());
        if (bo) {
            logger.info("SalerController.CheckInventoryIsEnough ==> inventory's product is not null");
            result.setStatus(InventoryConstant.PRODUCT_IS_NULL);
            result.setMessage(MessageConstant.PRODUCT_IS_NULL);
            //更新销售单的状态为-1（系统自动判断无货或者缺货状态）
            saleInfoService.updateSaleInfoStatusByOrderNumber(saleInfo.getOrderNumber(), "-1");
            return result;
        }
        InventoryInfo inventoryInfo = inventoryInfoService.selectInventotyInfoByExample(saleInfo.getProduct()).get(0);
        //库存数不足时
        if (inventoryInfo.getNumber() < saleInfo.getNumber()) {
            logger.info("SalerController.CheckInventoryIsEnough ==> inventory's product is not enough");
            result.setStatus(InventoryConstant.WAREHOUSE_NO_ENOUGH_NOT_AUDIT);
            result.setMessage(MessageConstant.PRODUCT_NUMBER_INSUFFICIENT);
            //更新销售单的状态为-1（系统自动判断无货或者缺货状态）
            saleInfoService.updateSaleInfoStatusByOrderNumber(saleInfo.getOrderNumber(), "-1");
            return result;
        }
        //InventoryInfo inventoryInfo = inventoryInfoService.selectInventotyInfoByExample(saleInfo.getProduct()).get(0);
        result.setStatus(InventoryConstant.WAREHOUSE_ENOUGH_NOT_AUDIT);
        result.setMessage(MessageConstant.WAREHOUSE_ENOUGH_NOT_AUDIT);
        //更新销售单的状态为1（系统自动判断有货状态）
        saleInfoService.updateSaleInfoStatusByOrderNumber(saleInfo.getOrderNumber(), "1");
        return result;
    }


    /**
     * 系统自动判断有货时==>销售主管自动获取未审批的销售单
     */
    @RequestMapping(value = "/manager/receive", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<SaleInfo>> selectAllNoAuditSaleInfo() {
        PageResponseBean<List<SaleInfo>> result = new PageResponseBean();
        //判断是否存在status为‘1’的销售单
        Boolean bo = saleInfoService.checkIsEmptyStatus("1");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        List<SaleInfo> saleInfos = saleInfoService.selectSaleInfoByStatus("1");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(saleInfos);
        return result;
    }


    /**
     * 系统自动判断有货时 ---> 销售主管审批通过,将销售单状态改为“2”，并且返回库管所需要的信息
     */
    @RequestMapping(value = "/manager/pass", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<OutputInfoDTO> CheckSaleInfoByManager(@RequestBody SaleInfo saleInfo) {
        ResponseBean<OutputInfoDTO> result = new ResponseBean<>();
        if (saleInfo == null) {
            logger.info("SalerController.CheckSaleInfoByManager ==> saleInfo is null");
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(InventoryConstant.WAREHOUSE_ENOUGH_PASS_AUDIT);
        result.setMessage(MessageConstant.WAREHOUSE_ENOUGH_PASS_AUDIT);
        //改变销售状态
        saleInfoService.updateSaleInfoStatusByOrderNumber(saleInfo.getOrderNumber(), "2");
        //封装库管需要的信息
        OutputInfoDTO outputInfoDTO = saleInfoService.encapsulationOutPutDTO(saleInfo);
        result.setData(outputInfoDTO);
        return result;
    }


    /**
     * 系统自动判断有货时 ---> 销售主管审批未通过,将销售单状态改为-2(1)
     */
    @RequestMapping(value = "/manager/nopass", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean CheckSaleInfoByManagerNoPass(@RequestBody SaleInfo saleInfo) {
        ResponseBean result = new ResponseBean();
        if (saleInfo == null) {
            logger.info("SalerController.CheckSaleInfoByManagerNoPass ==> saleInfo is null");
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(InventoryConstant.WAREHOUSE_ENOUGH_NO_PASS_AUDIT);
        result.setMessage(MessageConstant.WAREHOUSE_ENOUGH_NO_PASS_AUDIT);
        //改变销售状态
        saleInfoService.updateSaleInfoStatusByOrderNumber(saleInfo.getOrderNumber(), "-2");
        return result;
    }


    /**
     * 系统自动判断无货时==>销售主管自动获取未审批的销售单
     */
    @RequestMapping(value = "/manager/receive/noengouh", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<SaleInfo>> selectAllNoEnoughSaleInfo() {
        PageResponseBean<List<SaleInfo>> result = new PageResponseBean();
        //判断是否存在status为‘-1’的销售单
        Boolean bo = saleInfoService.checkIsEmptyStatus("-1");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_PENDING_SALES_ORDER);
            return result;
        }
        List<SaleInfo> saleInfos = saleInfoService.selectSaleInfoByStatus("-1");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(saleInfos);
        return result;
    }

    /**
     * 系统自动判断无货时--->销售主管审批通过并提取采购员需要的信息
     */
    @RequestMapping(value = "/noenough/manager/pass", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean CheckNoEnoughSaleInfoByManagerPass(@RequestBody SaleInfo saleInfo) {
        ResponseBean result = new ResponseBean();
        if (saleInfo == null) {
            logger.info("SalerController.CheckNoEnoughSaleInfoByManagerPass ==> saleInfo is null");
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(InventoryConstant.WAREHOUSE_NO_ENOUGH_PASS_AUDIT);
        result.setMessage(MessageConstant.WAREHOUSE_NO_ENOUGH_PASS_AUDIT);
        //改变销售单的状态为“3”
        saleInfoService.updateSaleInfoStatusByOrderNumber(saleInfo.getOrderNumber(), "3");
        //封装数据
        PurchaseDTO purchaseDTO = saleInfoService.encapsulationSaleInfoToPurchaseDTO(saleInfo);
        result.setData(purchaseDTO);
        return result;
    }


    /**
     * 系统自动判断无货时--->销售主管审批未通过
     */
    @RequestMapping(value = "/noenough/manager/nopass", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean CheckNoEnoughSaleInfoByManagerNoPass(@RequestBody SaleInfo saleInfo) {
        ResponseBean result = new ResponseBean();
        if (saleInfo == null) {
            logger.info("SalerController.CheckNoEnoughSaleInfoByManagerNoPass ==> saleInfo is null");
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        //改变销售单的状态为“-3”
        saleInfoService.updateSaleInfoStatusByOrderNumber(saleInfo.getOrderNumber(), "-3");
        result.setStatus(InventoryConstant.WAREHOUSE_NO_ENOUGH_NO_PASS_AUDIT);
        result.setMessage(MessageConstant.WAREHOUSE_NO_ENOUGH_NO_PASS_AUDIT);
        return result;
    }

    /**
     * 销售员获取系统自动判断有货时销售主管未通过的销售单
     */
    @RequestMapping(value = "/saler/gain/Enough", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<SaleInfo>> salerGainNoPassSaleInfoOfEnough() {
        PageResponseBean<List<SaleInfo>> result = new PageResponseBean();
        //判断是否存在status为‘-2’的销售单
        Boolean bo = saleInfoService.checkIsEmptyStatus("-2");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        List<SaleInfo> saleInfos = saleInfoService.selectSaleInfoByStatus("-2");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(saleInfos);
        return result;
    }


    /**
     * 销售员获取系统自动判断有货时销售主管未通过的销售单
     */
    @RequestMapping(value = "/saler/gain/No/Enough", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<SaleInfo>> salerGainNoPassSaleInfoOfNoEnough() {
        PageResponseBean<List<SaleInfo>> result = new PageResponseBean();
        //判断是否存在status为‘-3’的销售单
        Boolean bo = saleInfoService.checkIsEmptyStatus("-3");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        List<SaleInfo> saleInfos = saleInfoService.selectSaleInfoByStatus("-3");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(saleInfos);
        return result;
    }


    /**
     * 销售主管获取系统自动判断有货时==>销售主管获取未审批的销售单
     */
    @RequestMapping(value = "/manger/gain/Enough", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<SaleInfo>> mangerGainNoPassSaleInfoOfEnough() {
        PageResponseBean<List<SaleInfo>> result = new PageResponseBean();
        //判断是否存在status为‘-4’的销售单
        Boolean bo = saleInfoService.checkIsEmptyStatus("-4");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_PENDING_SALES_ORDER);
            return result;
        }
        List<SaleInfo> saleInfos = saleInfoService.selectSaleInfoByStatus("-4");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(saleInfos);
        return result;
    }
}