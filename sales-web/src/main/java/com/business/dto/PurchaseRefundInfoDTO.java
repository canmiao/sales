package com.business.dto;

import javax.persistence.Column;

/**
 *@Auther: ccm
 *@Description: 从入库单与质检单中抽取出采购退货所需要的属性
 *@Date: 2019/3/10 20:08
 */
public class PurchaseRefundInfoDTO {


    //在质检单中需要的属性

    /**
     * 供应商
     */
    private String provider;

    /**
     * 供应商联系电话
     */
    @Column(name = "privider_phone")
    private String providerPhone;

    /**
     * 抽样数量
     */
    @Column(name = "check_amount")
    private String checkAmount;

    /**
     * 检验情况
     */
    @Column(name = "check_result")
    private String checkResult;

    /**
     * 不良数量
     */
    @Column(name = "bad_number")
    private String badNumber;


    //在入库单单需要的属性

    /**
     * 仓库号
     */
    @Column(name = "warehouse_number")
    private String warehouseNumber;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 型号
     */
    private String model;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 产品单位
     */
    private String unit;

    /**
     * 产品单价
     */
    @Column(name = "unit_price")
    private Double unitPrice;

    /**
     * 库位地址
     */
    private String address;

    /**
     * 合计
     */
    @Column(name = "total_number")
    private Double combine;


    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderPhone() {
        return providerPhone;
    }

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }

    public String getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(String checkAmount) {
        this.checkAmount = checkAmount;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getBadNumber() {
        return badNumber;
    }

    public void setBadNumber(String badNumber) {
        this.badNumber = badNumber;
    }

    public String getWarehouseNumber() {
        return warehouseNumber;
    }

    public void setWarehouseNumber(String warehouseNumber) {
        this.warehouseNumber = warehouseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getCombine() {
        return combine;
    }

    public void setCombine(Double combine) {
        this.combine = combine;
    }
}
