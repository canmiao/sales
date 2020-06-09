package com.business.controller;

import com.business.bean.PageResponseBean;
import com.business.bean.PurchaseInfo;
import com.business.bean.SearchParam;
import com.business.common.CodeConstant;
import com.business.common.MessageConstant;
import com.business.common.ResponseBean;
import com.business.dto.PurchaseDTO;
import com.business.dto.PurchaseInputDTO;
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
* @Description:    采购控制
* @Author:         ccm
* @CreateDate:     2019/3/26 15:50
*/
@Controller
@RequestMapping(value = "/purchase")
public class PurchaseInfoController {
    private final static Logger logger = LoggerFactory.getLogger(PurchaseInfoController.class);
    
    @Resource
    private PurchaseInfoService purchaseInfoService;


    /**
     *  查询采购单信息
     * @param searchParam
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<PurchaseInfo>> selectAllPurchaseInfo(SearchParam searchParam) {
        PageResponseBean<List<PurchaseInfo>> result = new PageResponseBean<>();
        List<PurchaseInfo> purchaseInfos = purchaseInfoService.selectAllPurchaseIf(searchParam);
        if (purchaseInfos.isEmpty()) {
            logger.info("PurchaseInfoController ==> selectAllPurchaseInfo");
            result.setStatus(CodeConstant.NOT_EXIST);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(purchaseInfos);
        return result;
    }


    /**
     * 插入一条采购信息
     * @param purchaseInfo
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseInfo> insertPurchaseInfo(@RequestBody PurchaseInfo purchaseInfo) {
        ResponseBean<PurchaseInfo> result = new ResponseBean<>();
        if (purchaseInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        purchaseInfoService.insertPurchaseInfo(purchaseInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PURCHASEINFO_ADDED_SUCCESSFULLY);
        return result;
    }


    /**
     * 根据采购信息中的订单号更新采购信息
     * @param purchaseInfo
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseInfo> updatePurchaseInfo(@RequestBody PurchaseInfo purchaseInfo) {
        ResponseBean<PurchaseInfo> result = new ResponseBean<>();
        if (purchaseInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        if (null == purchaseInfoService.updatePurchaseInfo(purchaseInfo)) {
            result.setStatus(CodeConstant.NO_SUCH_PURCHASEINFO);
            result.setMessage(MessageConstant.NO_SUCH_PURCHASEINFO);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PURCHASEINFO_UPDATE_SUCCESSFULLY);
        return result;
    }


    /**
     * 删除一条采购信息
     * @param purchaseInfo
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseInfo> deletePurchaseInfo(@RequestBody PurchaseInfo purchaseInfo) {
        ResponseBean<PurchaseInfo> result = new ResponseBean<>();
        if (purchaseInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        purchaseInfoService.deletePurchaseInfo(purchaseInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PURCHASEINFO_DELETE_SUCCESSFULLY);
        return result;
    }


    /**
     * 采购员获取销售主管审批通过的信息
     */
    @RequestMapping(value = "/purchaseman/gain", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean<List<PurchaseDTO>> purchaseManGainSaleInfoPass() {
        ResponseBean<List<PurchaseDTO>> result = new ResponseBean<>();
        //判断是否存在status为‘3’的采购单
        Boolean bo = purchaseInfoService.checkIsEmptyStatus("3");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.PURCHASE_PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        List<PurchaseDTO> purchaseDTOS = purchaseInfoService.purchaseManSelectAllSaleInfo();
        if (CollectionUtils.isEmpty(purchaseDTOS)) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.RECEIVE_SUCCESS);
        result.setData(purchaseDTOS);
        return result;
    }


    /**
     * 采购主管获取到未审批的采购单
     */
    @RequestMapping(value = "/manager/gain", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<PurchaseInfo>> managerGainPurchaeInfoPass() {
        PageResponseBean<List<PurchaseInfo>> result = new PageResponseBean<>();
        //判断是否存在status为‘0’的采购单
        Boolean bo = purchaseInfoService.checkIsEmptyStatus("0");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.PURCHASE_PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        List<PurchaseInfo> purchaseInfos = purchaseInfoService.selectNoAuditPurchaseInfoByExample();
        if (purchaseInfos.isEmpty()) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_ALL_NOAUDIT_PURCHASE_INFORMATION);
        result.setData(purchaseInfos);
        return result;
    }


    /**
     * 采购主管审核通过，并将采购状态改为“1”
     * @param purchaseInfo
     * @return
     */
    @RequestMapping(value = "/manager/pass", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseInfo> auditPurchaeInfoPass(@RequestBody PurchaseInfo purchaseInfo) {
        ResponseBean<PurchaseInfo> result = new ResponseBean();
        if (purchaseInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        //改变采购状态
        purchaseInfoService.updatePurchasenfoStatus(purchaseInfo.getOrderNumber(), "1");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PURCHASE_PASS_AUDIT);
        return result;
    }



    /**
     * 采购主管审核未通过，并将采购状态改为“-1”
     * @param purchaseInfo
     * @return
     */
    @RequestMapping(value = "/manager/nopass", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseInfo> auditPurchaeInfoNopass(@RequestBody PurchaseInfo purchaseInfo) {
        ResponseBean<PurchaseInfo> result = new ResponseBean();
        if (purchaseInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        //改变采购状态
        purchaseInfoService.updatePurchasenfoStatus(purchaseInfo.getOrderNumber(), "-1");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PURCHASE_NOPASS_AUDIT);
        return result;
    }


    /**
     * 供应商获取到采购主管审核通过（"status = 1"）的采购单
     */
    @RequestMapping(value = "/provider/gain", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<PurchaseInfo>> providerGainPurchaeInfoPass() {
        PageResponseBean<List<PurchaseInfo>> result = new PageResponseBean<>();
        //判断是否存在status为‘1’的采购单
        Boolean bo = purchaseInfoService.checkIsEmptyStatus("1");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.PURCHASE_PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        List<PurchaseInfo> purchaseInfos = purchaseInfoService.selectPurchaseByStatus("1");
        if (CollectionUtils.isEmpty(purchaseInfos)) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_ALL_AUDIT_PURCHASE_INFORMATION);
        result.setData(purchaseInfos);
        return result;
    }


    /**
     * 采购员获取到供应商已确认通过的（"status = 2"）的采购单
     */
    @RequestMapping(value = "/purchase/provider/pass/gain", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<PurchaseInfo>> pruchaseManGainPurchaeInfoByProviderPass() {
        PageResponseBean<List<PurchaseInfo>> result = new PageResponseBean<>();
        //判断是否存在status为‘2’的采购单
        Boolean bo = purchaseInfoService.checkIsEmptyStatus("2");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.PURCHASE_PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        List<PurchaseInfo> purchaseInfos = purchaseInfoService.selectPurchaseByStatus("2");
        if (CollectionUtils.isEmpty(purchaseInfos)) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(purchaseInfos);
        return result;
    }


    /**
     * 供应商获取采购员已确认的采购订单（"status = 3"）的采购单
     */
    @RequestMapping(value = "/provider/purchase/pass/gain", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<PurchaseInfo>> providerManGainPurchaeInfoByPurchsePass() {
        PageResponseBean<List<PurchaseInfo>> result = new PageResponseBean<>();
        //判断是否存在status为‘3’的采购单
        Boolean bo = purchaseInfoService.checkIsEmptyStatus("3");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.PURCHASE_PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        List<PurchaseInfo> purchaseInfos = purchaseInfoService.selectPurchaseByStatus("3");
        if (CollectionUtils.isEmpty(purchaseInfos)) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(purchaseInfos);
        return result;
    }


    /**
     * 供应商未接单，并将采购状态改为“-2”
     * @param purchaseInfo
     * @return
     */
    @RequestMapping(value = "/provider/nopass", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseInfo> providerAuditPurchaeInfoNopass(@RequestBody PurchaseInfo purchaseInfo) {
        ResponseBean<PurchaseInfo> result = new ResponseBean();
        if (purchaseInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        //改变采购状态.
        purchaseInfoService.updatePurchasenfoStatus(purchaseInfo.getOrderNumber(), "-2");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PURCHASE_PASS_AUDIT_PROVIDER_REFUSE_ORDER);
        return result;
    }


    /**
     * 供应商接单，并将采购状态改为“2”
     * @param purchaseInfo
     * @return
     */
    @RequestMapping(value = "/provider/pass", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseInfo> providerAuditPurchaeInfoPass(@RequestBody PurchaseInfo purchaseInfo) {
        ResponseBean<PurchaseInfo> result = new ResponseBean();
        if (purchaseInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        //改变采购状态
        purchaseInfoService.updatePurchasenfoStatus(purchaseInfo.getOrderNumber(), "2");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PURCHASE_PASS_AUDIT_PROVIDER_TAKE_ORDER);
        return result;
    }


    /**
     * 采购员确认订单，并将采购状态改为“3”
     * @param purchaseInfo
     * @return
     */
    @RequestMapping(value = "/purchaseman/pass", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseInfo> purchaseManAuditPurchaeInfoPass(@RequestBody PurchaseInfo purchaseInfo) {
        ResponseBean<PurchaseInfo> result = new ResponseBean();
        if (purchaseInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        //改变采购状态
        purchaseInfoService.updatePurchasenfoStatus(purchaseInfo.getOrderNumber(), "3");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PURCHASE_MAN_MAKE_SURE_ORDER);
        return result;
    }


    /**
     * 供应商发货，并将采购信息设置为“4”，返回入库所需要的信息
     * @param purchaseInfo
     * @return
     */
    @RequestMapping(value = "/provide/send", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseInputDTO> providerSendPurchaeInfo(@RequestBody PurchaseInfo purchaseInfo) {
        ResponseBean<PurchaseInputDTO> result = new ResponseBean();
        if (purchaseInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        //改变采购状态
        purchaseInfoService.updatePurchasenfoStatus(purchaseInfo.getOrderNumber(), "4");
        //封装数据
        PurchaseInputDTO purchaseInputDTO = purchaseInfoService.encapsulationPurchaseInfoToInputMan(purchaseInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PROVIDER_DELIVERY);
        result.setData(purchaseInputDTO);
        return result;
    }


    /**
     * 采购员获取采购主管未审批通过的采购单
     */
    @RequestMapping(value = "/purchaseman/gain/by/manager", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean mangerGainNoPassSaleInfoOfEnough() {
        PageResponseBean result = new PageResponseBean();
        //判断是否存在status为‘-1’的采购单
        Boolean bo = purchaseInfoService.checkIsEmptyStatus("-1");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.PURCHASE_PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        List<PurchaseInfo> purchaseInfos = purchaseInfoService.selectPurchaseByStatus("-1");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(purchaseInfos);
        return result;
    }


    /**
     * 采购员获取到供应商未接单（"status = -2"）的采购单
     */
    @RequestMapping(value = "/purchase/provider/nopass/gain", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean<List<PurchaseInfo>> pruchaseManGainPurchaeInfoByProviderNoPass() {
        ResponseBean<List<PurchaseInfo>> result = new ResponseBean<>();
        //判断是否存在status为‘-2’的采购单
        Boolean bo = purchaseInfoService.checkIsEmptyStatus("-2");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.PURCHASE_PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        List<PurchaseInfo> purchaseInfos = purchaseInfoService.selectPurchaseByStatus("-2");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(purchaseInfos);
        return result;
    }


    /**
     * 采购员获取到质检未通过（"status = -5"）的采购单
     */
    @RequestMapping(value = "/purchase/checker/nopass/gain", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<PurchaseInfo>> pruchaseManGainPurchaeInfoByCheckerNoPass() {
        PageResponseBean<List<PurchaseInfo>> result = new PageResponseBean<>();
        //判断是否存在status为‘-5’的采购单
        Boolean bo = purchaseInfoService.checkIsEmptyStatus("-5");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.PURCHASE_PRODUCT_INFO_NOT_EXIST);
            return result;
        }
        List<PurchaseInfo> purchaseInfos = purchaseInfoService.selectPurchaseByStatus("-5");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(purchaseInfos);
        return result;
    }
}
