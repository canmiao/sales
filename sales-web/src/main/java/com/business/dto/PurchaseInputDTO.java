package com.business.dto;

import javax.persistence.Column;

/**
 * 存放入库员能从采购单中获取到的属性
 */
public class PurchaseInputDTO {
    private Long purchseId;

    /**
     * 供应商
     */
    private String provider;

    /**
     * 联系人电话
     */
    @Column(name = "provider_linkman_phone")
    private String providerLinkmanPhone;

    /**
     * 产品名称
     */
    @Column(name = "produce_name")
    private String produceName;

    /**
     * 产品型号
     */
    private String model;

    /**
     * 产品数量
     */
    private Integer amount;

    /**
     * 库位地址
     */
    @Column(name = "warehouse_adress")
    private String warehouseAdress;

    /**
     * 采购产品合计
     */
    @Column(name = "purchase_produce_sum")
    private Double purchaseProduceSum;

    public Long getPurchseId() {
        return purchseId;
    }

    public void setPurchseId(Long purchseId) {
        this.purchseId = purchseId;
    }

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
}
