package com.business.controller;

import com.business.bean.*;
import com.business.common.CodeConstant;
import com.business.common.MessageConstant;
import com.business.common.ResponseBean;
import com.business.dto.OutputInfoDTO;
import com.business.mapper.SaleInfoMapper;
import com.business.service.InventoryInfoService;
import com.business.service.OutputInfoService;
import com.business.service.SaleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description:    出库控制
* @Author:         ccm
* @CreateDate:     2019/3/25 22:24
*/
@Controller
@RequestMapping(value = "/output")
public class OutputInfoController {

    //日志
    private final static Logger logger = LoggerFactory.getLogger(InventoryInfoController.class);

    @Resource
    private OutputInfoService outputInfoService;

    @Resource
    private InventoryInfoService inventoryInfoService;

    @Resource
    private SaleInfoMapper saleInfoMapper;

    @Resource
    private SaleInfoService saleInfoService;


    /**
     *  查询出库单信息
     * @param searchParam
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<OutputInfo>> selectOutputInfoById(SearchParam searchParam) {
        PageResponseBean<List<OutputInfo>> result = new PageResponseBean<>();

        List<OutputInfo> outputInfos = outputInfoService.selectAllOutputIf(searchParam);
        if (outputInfos == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_INPUT_INFORMATION);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.SELECT_SUCCESS);
        result.setData(outputInfos);
        return result;
    }


    /**
     * 插入一条出库信息
     * @param outputInfo
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<OutputInfo> insertOutputInfo(@RequestBody OutputInfo outputInfo) {
        ResponseBean<OutputInfo> result = new ResponseBean<>();
        if (outputInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        outputInfoService.insetOutputInfo(outputInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.OUTPUTINFO_ADDED_SUCCESSFULLY);
        return result;
    }


    /**
     * 根据出库信息中的订单号更新出库信息
     * @param outputInfo
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<OutputInfo> updateOutputInfo(@RequestBody OutputInfo outputInfo) {
        ResponseBean<OutputInfo> result = new ResponseBean<>();
        if (outputInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        if (null == outputInfoService.updateOutputInfo(outputInfo)) {
            result.setStatus(CodeConstant.NO_SUCH_OUTPUTINFO);
            result.setMessage(MessageConstant.NO_SUCH_OUTPUTINFO);
            return result;
        }
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.OUTPUTINFO_UPDATE_SUCCESSFULLY);
        return result;
    }


    /**
     * 删除一条出库信息
     * @param outputInfo
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<OutputInfo> deleteOutputInfo(@RequestBody OutputInfo outputInfo) {
        ResponseBean<OutputInfo> result = new ResponseBean<>();
        if (outputInfo == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        outputInfoService.deleteOutputInfo(outputInfo);
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.OUTPUTINFO_DELETE_SUCCESSFULLY);
        return result;
    }


    /**
     * 库管员传入出库单，将商品出库-->更新新数据库
     */
    @RequestMapping(value = "/output", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean ExtractProduct(@RequestBody OutputInfo outputInfo) {
        ResponseBean result = new ResponseBean();
        if (outputInfo == null) {
            logger.info("OutputInfoController.ExtractProduct ==> outputInfo is null");
            result.setStatus(CodeConstant.NOT_EXIST);
            result.setMessage(MessageConstant.MESSAGE_RECEIVING_ERROR);
            return result;
        }
        //改变出库单的状态
        outputInfoService.updateOutputStatus(outputInfo.getOrderNumber(), "1");
        //更新库存
        inventoryInfoService.updateInventoryInfoNmuber(outputInfo.getGoodsName(), outputInfo.getNumber());
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.INVENTORY_INFO_OUTPUT_SUCCESSFULLY);
        logger.info("the outputInfo" +outputInfo.getGoodsName()+ "number is update！");
        return result;
    }


    /**
     * 销售主管审核通过==>库管接单，改变销售单状态为“4”
     */
    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean receiveSaleInfo(@RequestBody OutputInfoDTO outputInfoDTO) {
        ResponseBean result = new ResponseBean<>();
        if (outputInfoDTO == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        //改变销售状态
        SaleInfo saleInfo = saleInfoMapper.selectByPrimaryKey(outputInfoDTO.getId());
        //saleInfoService.updateSaleInfoStatus(saleInfo.getOrderNumber(), "4");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.OUPUT_RECEIVER_SALEINFO);
        return result;
    }


    /**
     * 销售主管审核通过==>库管不接单，改变销售单状态为“-4”
     */
    @RequestMapping(value = "/noreceive", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean noReceiveSaleInfo(@RequestBody OutputInfoDTO outputInfoDTO) {
        ResponseBean result = new ResponseBean<>();
        if (outputInfoDTO == null) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.FAILURE);
            return result;
        }
        //改变销售状态
        SaleInfo saleInfo = saleInfoMapper.selectByPrimaryKey(outputInfoDTO.getId());
        //saleInfoService.updateSaleInfoStatus(saleInfo.getOrderNumber//(), "-4");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.OUPUT_NO_RECEIVER_SALEINFO);
        return result;
    }


    /**
     * 出库员自动获取销售主管审批通过的信息
     */
    @RequestMapping(value = "/ouputer/receive", method = RequestMethod.GET)
    @ResponseBody
    public PageResponseBean<List<OutputInfoDTO>> outputerReceiveMessageBySaleInfo() {
        PageResponseBean<List<OutputInfoDTO>> result = new PageResponseBean<>();
        //判断是否存在status为‘2’的出库单
        Boolean bo = outputInfoService.checkIsEmptyStatus("2");
        if (bo) {
            result.setStatus(CodeConstant.ERROR);
            result.setMessage(MessageConstant.NO_SUCH_INPUTINFO);
            return result;
        }
        List<OutputInfoDTO> outputInfoDTOS = outputInfoService.selectOutputInfoDtoBySaleInfo("2");
        result.setStatus(CodeConstant.SUCCESS);
        result.setMessage(MessageConstant.RECEIVE_SUCCESS);
        result.setData(outputInfoDTOS);
        return result;
    }
}
