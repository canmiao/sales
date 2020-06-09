package com.business.controller;

import com.business.bean.*;
import com.business.common.CodeConstant;
import com.business.common.MessageConstant;
import com.business.common.ResponseBean;
import com.business.dto.CheckInfoDTO;
import com.business.dto.InventoryDTO;
import com.business.dto.PurchaseRefundInfoDTO;
import com.business.mapper.InputInfoMapper;
import com.business.mapper.PurchaseInfoMapper;
import com.business.service.CheckInfoService;
import com.business.service.InputInfoService;
import com.business.service.InventoryInfoService;
import com.business.service.PurchaseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:    质检单控制
* @Author:         ccm
* @CreateDate:     2019/3/26 11:38
*/
@Controller
@RequestMapping(value = "/check")
public class CheckInfoController {

    private final static Logger logger = LoggerFactory.getLogger(CheckInfoController.class);

    @Resource
    private CheckInfoService checkInfoService;

    @Resource
    private InputInfoService inputInfoService;

    @Resource
    private InventoryInfoService inventoryInfoService;

    @Resource
    private InputInfoMapper inputInfoMapper;

    @Resource
    private PurchaseInfoService purchaseInfoService;

    @Resource
    private PurchaseInfoMapper purchaseInfoMapper;


    /**
     *  查询质检单信息
     * @param searchParam
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<CheckInfo>> selectCheckInfoById(SearchParam searchParam) {
        PageResponseBean<List<CheckInfo>> result = new PageResponseBean<>();
        List<CheckInfo> checkInfos = checkInfoService.selectCheckInfoByExample(searchParam);
        if (checkInfos.isEmpty()) {
            logger.info("CheckInfoController ==> selectCheckInfoById");
            result.setStatus(CodeConstant.NOT_EXIST);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(checkInfos);
        return result;
    }


    /**
     * 插入一条质检信息
     * @param checkInfo
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<CheckInfo> insertCheckInfo(@RequestBody CheckInfo checkInfo) {
        ResponseBean<CheckInfo> result = new ResponseBean<>();
        if (checkInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        checkInfoService.insertCheckInfo(checkInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.CHECKINFO_ADDED_SUCCESSFULLY);
        return result;
    }


    /**
     * 根据质检信息中的订单号更新质检信息
     * @param checkInfo
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<CheckInfo> updateCheckInfo(@RequestBody CheckInfo checkInfo) {
        ResponseBean<CheckInfo> result = new ResponseBean<>();
        if (checkInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        if (null == checkInfoService.updateCheckInfo(checkInfo)) {
            result.setStatus(CodeConstant.NO_SUCH_CHECKINFO);
            result.setMessage(MessageConstant.NO_SUCH_CHECKINFO);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.CHECKINFO_UPDATE_SUCCESSFULLY);
        return result;
    }


    /**
     * 删除一条质检信息
     * @param checkInfo
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<CheckInfo> deleteCheckInfo(@RequestBody CheckInfo checkInfo) {
        ResponseBean<CheckInfo> result = new ResponseBean<>();
        if (checkInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        checkInfoService.deleteCheckInfo(checkInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.CHECKINFO_DELETE_SUCCESSFULLY);
        return result;
    }


    /**
     * 质检通过，质检员填写质检单存入数据库并设置质检单状态为“1”,并将对应入库单状态改为“1”（入库已质检状态），将对应采购单信息状态改为“5”
     */
    @RequestMapping(value = "/pass", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<InventoryDTO> checkInfoPass(@RequestBody CheckInfo checkInfo) {
        ResponseBean<InventoryDTO> result = new ResponseBean<>();
        if (checkInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        //增加质检信息
        checkInfoService.insertCheckInfo(checkInfo);
        //设置质检状态
        checkInfoService.updateCheckInfoStatus(checkInfo.getCheckOrder(), "1");
        //设置入库单状态
        inputInfoService.updateInputInfoStatus(checkInfo.getInputId() , "1");
        //设置采购单状态
        purchaseInfoService.updatePurchasenfoStatus(purchaseInfoMapper.selectByPrimaryKey(inputInfoMapper.selectByPrimaryKey(checkInfo.getInputId()).getPurchaseId()).getOrderNumber(), "5");
        //封装数据
        InventoryInfo inventoryInfo = inventoryInfoService.encapsulationInputInfo(inputInfoMapper.selectByPrimaryKey(checkInfo.getInputId()));
        //更新库存
        inventoryInfoService.updateInventoryInfoIncreaseNmuber(inventoryInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.CHECK_INFO_PASS);

        return result;
    }


    /**
     * 质检不通过，质检员填写质检单存入数据库并设置质检单状态为“-1”,并提取出采购退货所需要的信息
     */
    @RequestMapping(value = "/nopass", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseRefundInfoDTO> checkInfoNoPass(@RequestBody CheckInfo checkInfo) {
        ResponseBean<PurchaseRefundInfoDTO> result = new ResponseBean<>();
        if (checkInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        //增加质检信息
        checkInfoService.insertCheckInfo(checkInfo);
        //设置质检状态
        checkInfoService.updateCheckInfoStatus(checkInfo.getCheckOrder(), "-1");
        //设置入库单状态
        inputInfoService.updateInputInfoStatus(checkInfo.getInputId() , "-1");
        //设置采购单状态
        purchaseInfoService.updatePurchasenfoStatus(purchaseInfoMapper.selectByPrimaryKey(inputInfoMapper.selectByPrimaryKey(checkInfo.getInputId()).getPurchaseId()).getOrderNumber(), "-5");
        //封装数据
        PurchaseRefundInfoDTO purchaseRefundInfoDTO = checkInfoService.encapsulationPurchaseInfoDTO(checkInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.CHECK_INFO_NO_PASS);
        result.setData(purchaseRefundInfoDTO);
        return result;
    }


    /**
     * 质检员从入库单中获取到有效信息
     */
    @RequestMapping(value = "/check/gain", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<CheckInfoDTO>> purchaseManGainSaleInfoPass() {
        PageResponseBean<List<CheckInfoDTO>> result = new PageResponseBean<>();
        //判断是否存在status为‘0’的质检单
        Boolean bo = checkInfoService.checkIsEmptyStatus("0");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_CHECK_INFORMATION);
            return result;
        }
        List<CheckInfoDTO> checkInfoDTOS = checkInfoService.purchaseManSelectAllSaleInfo("0");
        if (CollectionUtils.isEmpty(checkInfoDTOS)) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.RECEIVE_SUCCESS);
        result.setData(checkInfoDTOS);
        return result;
    }
}
