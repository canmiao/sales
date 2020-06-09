package com.business.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
* @Description:    存放出库员能从销售单中看到的数据
* @Author:         ccm
* @CreateDate:     2019/3/30 15:22
*/
public class OutputInfoDTO {
    /**
     * 关联销售单的键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 客户
     */
    private String customer;

    /**
     * 客户联系电话
     */
    @Column(name = "customer_phone")
    private String customerPhone;

    /**
     * 客户公司
     */
    @Column(name = "customer_company")
    private String customerCompany;

    /**
     * 付款方式
     */
    @Column(name = "payment_type")
    private String paymentType;

    /**
     * 币种
     */
    @Column(name = "cu_type")
    private String cuType;

    /**
     * 付款账户
     */
    @Column(name = "payment_account")
    private String paymentAccount;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
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
     * 产品信息备注
     */
    @Column(name = "product_comment")
    private String productComment;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 收货地址
     */
    @Column(name = "receiver_address")
    private String receiverAddress;

    /**
     * 收货邮编
     */
    @Column(name = "receiver_express_code")
    private String receiverExpressCode;

    /**
     * 收货人手机号码
     */
    @Column(name = "receiver_mobilephone")
    private String receiverMobilephone;

    /**
     * 收货人电话
     */
    @Column(name = "receiver_phone")
    private String receiverPhone;

    /**
     * 省份
     */
    @Column(name = "receiver_province")
    private String receiverProvince;

    /**
     * 城市
     */
    @Column(name = "receiver_city")
    private String receiverCity;

    /**
     * 县区
     */
    @Column(name = "receiver_county")
    private String receiverCounty;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCuType() {
        return cuType;
    }

    public void setCuType(String cuType) {
        this.cuType = cuType;
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
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

    public String getProductComment() {
        return productComment;
    }

    public void setProductComment(String productComment) {
        this.productComment = productComment;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverExpressCode() {
        return receiverExpressCode;
    }

    public void setReceiverExpressCode(String receiverExpressCode) {
        this.receiverExpressCode = receiverExpressCode;
    }

    public String getReceiverMobilephone() {
        return receiverMobilephone;
    }

    public void setReceiverMobilephone(String receiverMobilephone) {
        this.receiverMobilephone = receiverMobilephone;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverCounty() {
        return receiverCounty;
    }

    public void setReceiverCounty(String receiverCounty) {
        this.receiverCounty = receiverCounty;
    }
}
