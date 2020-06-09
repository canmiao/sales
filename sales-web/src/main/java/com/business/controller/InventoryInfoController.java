package com.business.controller;

import com.business.bean.*;
import com.business.common.CodeConstant;
import com.business.common.InventoryConstant;
import com.business.common.MessageConstant;
import com.business.common.ResponseBean;
import com.business.service.InventoryInfoService;
import com.business.service.OutputInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/inventory")
public class InventoryInfoController {
    //日志
    private final static Logger logger = LoggerFactory.getLogger(InventoryInfoController.class);

    @Resource
    InventoryInfoService inventoryInfoService;

    @Resource
    OutputInfoService outputInfoService;


    /**
     * 查询全部库存
     */
    @RequestMapping(value = "/select/all", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<InventoryInfo>> selectAllInventoryByProduct() {
        PageResponseBean<List<InventoryInfo>> result = new PageResponseBean<>();
        List<InventoryInfo> inventoryInfos = inventoryInfoService.selectAllInventotyInfoByExample();
        if (inventoryInfos.isEmpty()) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(inventoryInfos);
        return result;

    }


    /**
     * 查询库存
     * @param searchParam
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<InventoryInfo>> selectInventoryByProduct(SearchParam searchParam) {
        PageResponseBean<List<InventoryInfo>> result = new PageResponseBean<>();
        List<InventoryInfo> inventoryInfo = inventoryInfoService.selectAllInventoryInfo(searchParam);
        if (inventoryInfo.isEmpty()) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_INVENTORY_INFORMATION);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(inventoryInfo);
        return result;
    }


    /**
     * 插入一条入库信息
     * @param inventoryInfo
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<InventoryInfo> insertInventoryInfo(@RequestBody InventoryInfo inventoryInfo) {
        ResponseBean<InventoryInfo> result = new ResponseBean<>();
        if (inventoryInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        inventoryInfoService.insetInventoryInfo(inventoryInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.INVENTORY_INFO_ADDED_SUCCESSFULLY);
        return result;
    }


    /**
     * 根据入库信息中的订单号更新入库信息
     * @param inventoryInfo
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<InventoryInfo> updateInventoryInfo(@RequestBody InventoryInfo inventoryInfo) {
        ResponseBean<InventoryInfo> result = new ResponseBean<>();
        if (inventoryInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        if (null ==inventoryInfoService.updateInventoryInfo(inventoryInfo)) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_SUCH_INVENTORY_INFO);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.INVENTORY_INFO_UPDATE_SUCCESSFULLY);
        return result;
    }


    /**
     * 删除一条入库信息
     * @param inventoryInfo
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<InventoryInfo> deleteInputInfo(@RequestBody InventoryInfo inventoryInfo) {
        ResponseBean<InventoryInfo> result = new ResponseBean<>();
        if (inventoryInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        inventoryInfoService.deleteInventoryInfo(inventoryInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.INVENTORY_INFO_DELETE_SUCCESSFULLY);
        return result;
    }


    /**
     * 库管接单出现错误
     */
    @RequestMapping(value = "/receive/wrong", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean ReceiveSaleInfoWrong(@RequestBody SaleInfo saleInfo) {
        ResponseBean result = new ResponseBean();
        if (saleInfo == null) {
            logger.info("InventoryController.ReceiveSaleInfoWrong ==> saleInfo is null");
            result.setStatus(CodeConstant.NOT_EXIST);
            result.setMessage(MessageConstant.MESSAGE_RECEIVING_ERROR);
            return result;
        }
        result.setStatus(InventoryConstant.INPUT_ERROR);
        result.setMessage(MessageConstant.INPUT_ERROR);
        result.setData(saleInfo);
        return result;
    }


    /**
     * 库管员传入出库单，将商品出库-->改变出库单状态为“1”更新新数据库
     */
    @RequestMapping(value = "/output", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean ExtractProduct(@RequestBody OutputInfo outputInfo) {
        ResponseBean result = new ResponseBean();
        if (outputInfo == null) {
            logger.info("InventoryController.ExtractProduct ==> outputInfo is null");
            result.setStatus(CodeConstant.NOT_EXIST);
            result.setMessage(MessageConstant.MESSAGE_RECEIVING_ERROR);
            return result;
        }
        //添加出库单
        outputInfoService.insetOutputInfo(outputInfo);
        //更新库存
        inventoryInfoService.updateInventoryInfoNmuber(outputInfo.getGoodsName(), outputInfo.getNumber());
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.INVENTORY_INFO_OUTPUT_SUCCESSFULLY);
        logger.info("the outputInfo" +outputInfo.getGoodsName()+ "number is update！");
        return result;
    }


    /**
     * 库管收货填写入库单，设置默认状态为收货未质检
     */
    @RequestMapping(value = "/input", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean receiveInputInfo(@RequestBody InputInfo inputInfo) {
        ResponseBean result = new ResponseBean();
        if (inputInfo == null) {
            logger.info("InventoryController.receiveInputInfo ==> inputInfo is null");
            result.setStatus(CodeConstant.NOT_EXIST);
            result.setMessage(MessageConstant.MESSAGE_RECEIVING_ERROR);
            return result;
        }
        result.setStatus(InventoryConstant.INPUT_NOT_CHECK_STATUS);
        result.setMessage(MessageConstant.INPUT_NOT_CHECK_STATUS);
        result.setData(inputInfo);
        return result;
    }
}
