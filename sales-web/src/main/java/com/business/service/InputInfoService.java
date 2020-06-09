package com.business.service;

import com.business.bean.InputInfo;
import com.business.bean.PurchaseInfo;
import com.business.bean.SearchParam;
import com.business.dto.CheckInfoDTO;
import com.business.dto.PurchaseInputDTO;
import com.business.dto.PurchaseRefundInfoDTO;
import com.business.mapper.InputInfoMapper;
import com.business.mapper.PurchaseInfoMapper;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
* @Description:    入库信息操作
* @Author:         ccm
* @CreateDate:     2019/3/23 14:56
*/
@Service
public class InputInfoService {
    private final static Logger logger = LoggerFactory.getLogger(InputInfoService.class);

    @Resource
    private InputInfoMapper inputInfoMapper;

    @Resource
    private PurchaseInfoMapper purchaseInfoMapper;

    @Resource
    private PurchaseInfoService purchaseInfoService;


    /**
     * 查询所有入库信息
     * @param searchParam
     * @return
     */
    public List<InputInfo> selectAllPurchaseIf(SearchParam searchParam) {
        logger.info("InputInfoService ==> selectAllPurchaseIf");
        if (searchParam.getPageNum() != null || searchParam.getPageSize() != null) {
            PageHelper.startPage(searchParam);
        }
        return inputInfoMapper.selectAllInputInfo(searchParam.getKeyWord());
    }



    /**
     * 入库信息查询(已测试)
     */
    public List<InputInfo> selectInputInfoByExample(String keyWord) {
        if (keyWord == null) {
            logger.info("InputInfoService == > selectInputInfoByExample the keyWord is null");
            return null;
        }
        String newKeyWord = "%"+keyWord+"%";
        Example example = new Example(InputInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("orderNumber", newKeyWord);
        criteria.orLike("tableMakedate", newKeyWord);
        criteria.orLike("provider", newKeyWord);
        criteria.orLike("providerPhone", newKeyWord);
        criteria.orLike("paymentMethod", newKeyWord);
        criteria.orLike("cuType", newKeyWord);
        criteria.orLike("payAccount", newKeyWord);
        criteria.orLike("incomingPart", newKeyWord);
        criteria.orLike("incomingPartPhone", newKeyWord);
        criteria.orLike("shippingDate", newKeyWord);
        criteria.orLike("deliveryRequirements", newKeyWord);
        criteria.orLike("inputType", newKeyWord);
        criteria.orLike("warehouseNumber", newKeyWord);
        criteria.orLike("inputNote", newKeyWord);
        criteria.orLike("product", newKeyWord);
        criteria.orLike("name", newKeyWord);
        criteria.orLike("model", newKeyWord);
        criteria.orLike("specification", newKeyWord);
        criteria.orLike("number", newKeyWord);
        criteria.orLike("productProvider", newKeyWord);
        criteria.orLike("barcode", newKeyWord);
        criteria.orLike("address", newKeyWord);
        criteria.orLike("combine", newKeyWord);
        criteria.orLike("produceNote", newKeyWord);
        criteria.orLike("audit", newKeyWord);
        criteria.orLike("keepAccounts", newKeyWord);
        criteria.orLike("departmentHead", newKeyWord);
        criteria.orLike("controller", newKeyWord);
        criteria.orLike("tableMaker", newKeyWord);

        List<InputInfo> inputInfos = inputInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(inputInfos)) {
            logger.info("InputInfoService == > selectInputInfoByExample the product is null");
            return null;
        }
        return inputInfos;
    }


    /**
     * 根据入库订单号修改入库单信息(已测试)
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateInputInfo(InputInfo inputInfo) {
        if (inputInfo == null) {
            logger.info("InputInfoService == > updateInputInfo the inputInfo is null");
            return null;
        }
        //InputInfo对应数据库中的表
        Example example = new Example(InputInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //orderNumber是主键
        criteria.andEqualTo("orderNumber",inputInfo.getOrderNumber());
        if (inputInfoMapper.selectByExample(example).isEmpty()) {
            return null;
        }
        //调用更新数据的函数
        return inputInfoMapper.updateByExample(inputInfo,example);
    }


    /**
     * 删除入库单（已测试）
     */
    public void deleteInputInfo(InputInfo inputInfo) {
        Example example = new Example(InputInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderNumber", inputInfo.getOrderNumber());
        inputInfoMapper.deleteByExample(example);
    }


    /**
     * 添加入库单（已测试）
     */
    public void insetInputInfo(InputInfo inputInfo) {
        inputInfoMapper.insert(inputInfo);
    }


    /**
     * 根据关联id更改入库单的状态"status"
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer updateInputInfoStatus(Long inputId, String newStatus) {

        Example example = new Example(InputInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", inputId);
        InputInfo inputInfo = inputInfoMapper.selectByExample(example).get(0);
        inputInfo.setStatus(newStatus);
        return updateInputInfo(inputInfo);
    }


    /**
     * 入库员查询供应商发货但未收货信息
     */
    public List<PurchaseInputDTO> selectNoInputInfo(String status) {
        Example example = new Example(PurchaseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        List<PurchaseInfo> purchaseInfos = purchaseInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(purchaseInfos)) {
            logger.info("InputInfoService == > selectNoInputInfo the product is null");
            return null;
        }
        List<PurchaseInputDTO> purchaseInputDTOS = new ArrayList<PurchaseInputDTO>();
        PurchaseInfo purchaseInfo = new PurchaseInfo();
        for (Iterator iterator = purchaseInfos.iterator(); iterator.hasNext();) {
            purchaseInfo = (PurchaseInfo)iterator.next();
            PurchaseInputDTO purchaseInputDTO = purchaseInfoService.encapsulationPurchaseInfoToInputMan(purchaseInfo);
            purchaseInputDTOS.add(purchaseInputDTO);
        }
        return purchaseInputDTOS;
    }


    /**
     * 从入库单中抽取质检所需要的信息
     */
    public CheckInfoDTO encapsulationInputInfoToCheck(InputInfo inputInfo) {
        CheckInfoDTO checkInfoDTO = new CheckInfoDTO();
        checkInfoDTO.setInputId(inputInfo.getId());
        checkInfoDTO.setNumber(inputInfo.getNumber());
        checkInfoDTO.setProvider(inputInfo.getProvider());
        checkInfoDTO.setProviderPhone(inputInfo.getProviderPhone());
        checkInfoDTO.setName(inputInfo.getProduct());
        return checkInfoDTO;
    }


    /**
     * 检查是否存在指定状态的入库单
     * @param status
     * @return
     */
    public Boolean checkIsEmptyStatus(String status) {
        if (StringUtils.isBlank(status)) {
            logger.info("InputInfoService == > checkIsEmptyStatus the status is blank");
            return null;
        }
        Example example = new Example(InputInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", status);
        List<InputInfo> inputInfos = inputInfoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(inputInfos);
    }
}
