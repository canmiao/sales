package com.business.dto;

import javax.persistence.Column;

/**
 *@Auther: ccm
 *@Description: 从采购单中提取出库管能看到的属性
 *@Date: 2019/3/10 16:27
 */
public class InventoryByPurchaseDTO {
    /**
     * 供应商
     */
    private String provider;

    /**
     * 联系人电话
     */
    private String providerLinkmanPhone;

    /**
     * 产品名称
     */
    private String produceName;

    /**
     * 产品型号
     */
    private String model;

    /**
     * 产品规格
     */
    private String specification;

    /**
     * 产品数量
     */
    private Integer amount;

    /**
     * 库位地址
     */
    private String warehouseAdress;

    /**
     * 采购产品合计
     */
    private Double purchaseProduceSum;

    /**
     * 结算方式
     */
    private String clearingForm;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderLinkmanPhone() {
        return providerLinkmanPhone;
    }

    public void setProviderLinkmanPhone(String providerLinkmanPhone) {
        this.providerLinkmanPhone = providerLinkmanPhone;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getWarehouseAdress() {
        return warehouseAdress;
    }

    public void setWarehouseAdress(String warehouseAdress) {
        this.warehouseAdress = warehouseAdress;
    }

    public Double getPurchaseProduceSum() {
        return purchaseProduceSum;
    }

    public void setPurchaseProduceSum(Double purchaseProduceSum) {
        this.purchaseProduceSum = purchaseProduceSum;
    }

    public String getClearingForm() {
        return clearingForm;
    }

    public void setClearingForm(String clearingForm) {
        this.clearingForm = clearingForm;
    }
}
