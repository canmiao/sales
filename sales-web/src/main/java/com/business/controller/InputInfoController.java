package com.business.controller;

import com.business.bean.InputInfo;
import com.business.bean.PageResponseBean;
import com.business.bean.SearchParam;
import com.business.common.CodeConstant;
import com.business.common.MessageConstant;
import com.business.common.ResponseBean;
import com.business.dto.CheckInfoDTO;
import com.business.dto.PurchaseInputDTO;
import com.business.service.InputInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:    入库控制
* @Author:         ccm
* @CreateDate:     2019/3/25 21:20
*/
@Controller
@RequestMapping(value = "/input")
public class InputInfoController {

    @Resource
    private InputInfoService inputInfoService;


    /**
     *  查询入库单信息
     * @param searchParam
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<InputInfo>> selectInputInfoById(SearchParam searchParam) {
        PageResponseBean<List<InputInfo>> result = new PageResponseBean<>();
        List<InputInfo> inputInfos = inputInfoService.selectAllPurchaseIf(searchParam);
        if (inputInfos.isEmpty()) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_INPUT_INFORMATION);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(inputInfos);
        return result;
    }


    /**
     * 插入一条入库信息
     * @param inputInfo
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<InputInfo> insertInputInfo(@RequestBody InputInfo inputInfo) {
        ResponseBean<InputInfo> result = new ResponseBean<>();
        if (inputInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        inputInfoService.insetInputInfo(inputInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.INPUTINFO_ADDED_SUCCESSFULLY);
        return result;
    }


    /**
     * 根据入库信息中的订单号更新入库信息
     * @param inputInfo
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<InputInfo> updateInputInfo(@RequestBody InputInfo inputInfo) {
        ResponseBean<InputInfo> result = new ResponseBean<>();
        if (inputInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        if (null ==inputInfoService.updateInputInfo(inputInfo)) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_SUCH_INPUTINFO);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.INPUTINFO_UPDATE_SUCCESSFULLY);
        return result;
    }


    /**
     * 删除一条入库信息
     * @param inputInfo
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<InputInfo> deleteInputInfo(@RequestBody InputInfo inputInfo) {
        ResponseBean<InputInfo> result = new ResponseBean<>();
        if (inputInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        inputInfoService.deleteInputInfo(inputInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.INPUTINFO_DELETE_SUCCESSFULLY);
        return result;
    }


    /**
     * 入库员传入入库单，系统增加入库单，并返回质检所需要的数据
     */
    @RequestMapping(value = "/input", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<CheckInfoDTO> inputInputInfo(@RequestBody InputInfo inputInfo) {
        ResponseBean<CheckInfoDTO> result = new ResponseBean<>();
        if (inputInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        //添加入库单
        insertInputInfo(inputInfo);
        //封装数据
        CheckInfoDTO checkInfoDTO = inputInfoService.encapsulationInputInfoToCheck(inputInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.INPUTINFO_ADDED_SUCCESSFULLY);
        result.setData(checkInfoDTO);
        return result;
    }


    /**
     * 库管查询供应商发货而库管未收货的信息
     */
    @RequestMapping(value = "/inputer/gain", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<PurchaseInputDTO>> purchaseManGainSaleInfoPass() {
        PageResponseBean<List<PurchaseInputDTO>> result = new PageResponseBean<>();
        //判断是否存在status为‘4’的入库单
        Boolean bo = inputInfoService.checkIsEmptyStatus("4");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_INPUT_INFORMATION);
            return result;
        }
        List<PurchaseInputDTO> purchaseInputDTOS = inputInfoService.selectNoInputInfo("4");
        if (CollectionUtils.isEmpty(purchaseInputDTOS)) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.IS_NOT_EXIST);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.RECEIVE_SUCCESS);
        result.setData(purchaseInputDTOS);
        return result;
    }
}
