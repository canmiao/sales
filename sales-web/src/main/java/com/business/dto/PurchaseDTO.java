package com.business.dto;

/**
 *@Auther: ccm
 *@Description: 从销售单中抽取出采购员能看到的属性
 *@Date: 2019/3/10 15:38
 */
public class PurchaseDTO {

    /**
     * 关联销售单的键
     */
    private Long saleInfoId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品型号
     */
    private String model;

    /**
     * 产品规格
     */
    private String size;

    /**
     * 产品数
     */
    private Integer number;

    /**
     * 产品单位
     */
    private String unit;

    /**
     * 产品单价
     */
    private Double unitPrice;

    /**
     * 库位地址
     */
    private String warehouseAddress;


    public Long getSaleInfoId() {
        return saleInfoId;
    }

    public void setSaleInfoId(Long saleInfoId) {
        this.saleInfoId = saleInfoId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }
}
