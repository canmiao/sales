package com.business.controller;

import com.business.bean.PageResponseBean;
import com.business.bean.PurchaseInfo;
import com.business.bean.PurchaseRetundInfo;
import com.business.bean.SearchParam;
import com.business.common.CodeConstant;
import com.business.common.MessageConstant;
import com.business.common.ResponseBean;
import com.business.dto.PurchaseInputDTO;
import com.business.dto.PurchaseRefundInfoDTO;
import com.business.service.PurchaseRetundInfoService;
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
* @Description:    采购退货控制
* @Author:         ccm
* @CreateDate:     2019/3/26 16:24
*/
@Controller
@RequestMapping(value = "/purchase/retund")
public class PurchaseRetundInfoController {

    private final static Logger logger = LoggerFactory.getLogger(PurchaseRetundInfoController.class);

    @Resource
    private PurchaseRetundInfoService purchaseRetundInfoService;


    /**
     *  查询采购退货单信息
     * @param searchParam
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<PurchaseRetundInfo>> selectPurchaseRetundInfoById(SearchParam searchParam) {
        PageResponseBean<List<PurchaseRetundInfo>> result = new PageResponseBean<>();
        List<PurchaseRetundInfo> purchaseRetundInfos = purchaseRetundInfoService.selectPurchaseRetundInfoByExample(searchParam);
        if (purchaseRetundInfos.isEmpty()) {
            logger.info("PurchaseRetundInfoController ==> selectPurchaseRetundInfoById");
            result.setStatus(CodeConstant.NOT_EXIST);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(purchaseRetundInfos);
        return result;
    }


    /**
     * 插入一条采购退货信息
     * @param purchaseRetundInfo
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseRetundInfo> insertPurchaseRetundInfo(@RequestBody PurchaseRetundInfo purchaseRetundInfo) {
        ResponseBean<PurchaseRetundInfo> result = new ResponseBean<>();
        if (purchaseRetundInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        purchaseRetundInfoService.insetPurchaseRetundInfo(purchaseRetundInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PURCHASE_RETUND_INFO_ADDED_SUCCESSFULLY);
        return result;
    }


    /**
     * 根据采购退货信息中的订单号更新采购退货信息
     * @param purchaseRetundInfo
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseRetundInfo> updateInputInfo(@RequestBody PurchaseRetundInfo purchaseRetundInfo) {
        ResponseBean<PurchaseRetundInfo> result = new ResponseBean<>();
        if (purchaseRetundInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        if (null == purchaseRetundInfoService.updatePurchaseRetundInfo(purchaseRetundInfo)) {
            result.setStatus(CodeConstant.NO_SUCH_PURCHASE_RETUND_INFO);
            result.setMessage(MessageConstant.NO_SUCH_PURCHASE_RETUND_INFO);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PURCHASE_RETUND_INFO_UPDATE_SUCCESSFULLY);
        return result;
    }


    /**
     * 删除一条采购退货信息
     * @param purchaseRetundInfo
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<PurchaseRetundInfo> deleteInputInfo(@RequestBody PurchaseRetundInfo purchaseRetundInfo) {
        ResponseBean<PurchaseRetundInfo> result = new ResponseBean<>();
        if (purchaseRetundInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        purchaseRetundInfoService.deletePurchaseRetundInfo(purchaseRetundInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.PURCHASE_RETUND_INFO_DELETE_SUCCESSFULLY);
        return result;
    }


    /**
     * 采购员自动获取质检单个入库单中的有效信息
     */
    @RequestMapping(value = "/gain", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<PurchaseRefundInfoDTO>> purchaseManGainSaleInfoPass() {
        PageResponseBean<List<PurchaseRefundInfoDTO>> result = new PageResponseBean<>();
        //判断是否存在status为‘1’的采购退货单
        Boolean bo = purchaseRetundInfoService.checkIsEmptyStatus("1");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_PURCHASE_RETUND_INFORMATION);
            return result;
        }
        List<PurchaseRefundInfoDTO> purchaseIpnputDTOS = purchaseRetundInfoService.purchaseReturnManSelectAllInfo("1");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.RECEIVE_SUCCESS);
        result.setData(purchaseIpnputDTOS);
        return result;
    }
}
