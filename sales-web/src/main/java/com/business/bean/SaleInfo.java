package com.business.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_saleinfo")
public class SaleInfo implements Serializable {
    /**
     * 自增标识主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 产品
     */
    private String product;

    /**
     * 产品型号
     */
    private String model;

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
    @Column(name = "unit_price")
    private Double unitPrice;

    /**
     * 库位地址
     */
    @Column(name = "warehouse_address")
    private String warehouseAddress;

    /**
     * 合计
     */
    private Double combine;

    /**
     * 订单号
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 制表日期
     */
    @Column(name = "table_make_time")
    private Date tableMakeTime;

    /**
     * 客户
     */
    private String customer;

    /**
     * 客户条码
     */
    @Column(name = "customer_code")
    private String customerCode;

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
     * 销售员
     */
    private String saler;

    /**
     * 销售员条码
     */
    @Column(name = "saler_code")
    private String salerCode;

    /**
     * 销售员联系电话
     */
    @Column(name = "saler_phone")
    private String salerPhone;

    /**
     * 下单日期
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 销售员备注
     */
    @Column(name = "saler_remark")
    private String salerRemark;

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

    /**
     * 产品信息备注
     */
    @Column(name = "product_comment")
    private String productComment;

    /**
     * 另一备注
     */
    @Column(name = "another_product_comment")
    private String anotherProductComment;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增标识主键
     *
     * @return id - 自增标识主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增标识主键
     *
     * @param id 自增标识主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取产品
     *
     * @return product - 产品
     */
    public String getProduct() {
        return product;
    }

    /**
     * 设置产品
     *
     * @param product 产品
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * 获取产品型号
     *
     * @return model - 产品型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置产品型号
     *
     * @param model 产品型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取产品数
     *
     * @return number - 产品数
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置产品数
     *
     * @param number 产品数
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取产品单位
     *
     * @return unit - 产品单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置产品单位
     *
     * @param unit 产品单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取产品单价
     *
     * @return unit_price - 产品单价
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置产品单价
     *
     * @param unitPrice 产品单价
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 获取库位地址
     *
     * @return warehouse_address - 库位地址
     */
    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    /**
     * 设置库位地址
     *
     * @param warehouseAddress 库位地址
     */
    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    /**
     * 获取合计
     *
     * @return combine - 合计
     */
    public Double getCombine() {
        return combine;
    }

    /**
     * 设置合计
     *
     * @param combine 合计
     */
    public void setCombine(Double combine) {
        this.combine = combine;
    }

    /**
     * 获取订单号
     *
     * @return order_number - 订单号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置订单号
     *
     * @param orderNumber 订单号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取制表日期
     *
     * @return table_make_time - 制表日期
     */
    public Date getTableMakeTime() {
        return tableMakeTime;
    }

    /**
     * 设置制表日期
     *
     * @param tableMakeTime 制表日期
     */
    public void setTableMakeTime(Date tableMakeTime) {
        this.tableMakeTime = tableMakeTime;
    }

    /**
     * 获取客户
     *
     * @return customer - 客户
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * 设置客户
     *
     * @param customer 客户
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * 获取客户条码
     *
     * @return customer_code - 客户条码
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * 设置客户条码
     *
     * @param customerCode 客户条码
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * 获取客户联系电话
     *
     * @return customer_phone - 客户联系电话
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * 设置客户联系电话
     *
     * @param customerPhone 客户联系电话
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * 获取客户公司
     *
     * @return customer_company - 客户公司
     */
    public String getCustomerCompany() {
        return customerCompany;
    }

    /**
     * 设置客户公司
     *
     * @param customerCompany 客户公司
     */
    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
    }

    /**
     * 获取付款方式
     *
     * @return payment_type - 付款方式
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * 设置付款方式
     *
     * @param paymentType 付款方式
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 获取币种
     *
     * @return cu_type - 币种
     */
    public String getCuType() {
        return cuType;
    }

    /**
     * 设置币种
     *
     * @param cuType 币种
     */
    public void setCuType(String cuType) {
        this.cuType = cuType;
    }

    /**
     * 获取付款账户
     *
     * @return payment_account - 付款账户
     */
    public String getPaymentAccount() {
        return paymentAccount;
    }

    /**
     * 设置付款账户
     *
     * @param paymentAccount 付款账户
     */
    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    /**
     * 获取销售员
     *
     * @return saler - 销售员
     */
    public String getSaler() {
        return saler;
    }

    /**
     * 设置销售员
     *
     * @param saler 销售员
     */
    public void setSaler(String saler) {
        this.saler = saler;
    }

    /**
     * 获取销售员条码
     *
     * @return saler_code - 销售员条码
     */
    public String getSalerCode() {
        return salerCode;
    }

    /**
     * 设置销售员条码
     *
     * @param salerCode 销售员条码
     */
    public void setSalerCode(String salerCode) {
        this.salerCode = salerCode;
    }

    /**
     * 获取销售员联系电话
     *
     * @return saler_phone - 销售员联系电话
     */
    public String getSalerPhone() {
        return salerPhone;
    }

    /**
     * 设置销售员联系电话
     *
     * @param salerPhone 销售员联系电话
     */
    public void setSalerPhone(String salerPhone) {
        this.salerPhone = salerPhone;
    }

    /**
     * 获取下单日期
     *
     * @return order_time - 下单日期
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置下单日期
     *
     * @param orderTime 下单日期
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取销售员备注
     *
     * @return saler_remark - 销售员备注
     */
    public String getSalerRemark() {
        return salerRemark;
    }

    /**
     * 设置销售员备注
     *
     * @param salerRemark 销售员备注
     */
    public void setSalerRemark(String salerRemark) {
        this.salerRemark = salerRemark;
    }

    /**
     * 获取收货人
     *
     * @return receiver - 收货人
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 设置收货人
     *
     * @param receiver 收货人
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 获取收货地址
     *
     * @return receiver_address - 收货地址
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * 设置收货地址
     *
     * @param receiverAddress 收货地址
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * 获取收货邮编
     *
     * @return receiver_express_code - 收货邮编
     */
    public String getReceiverExpressCode() {
        return receiverExpressCode;
    }

    /**
     * 设置收货邮编
     *
     * @param receiverExpressCode 收货邮编
     */
    public void setReceiverExpressCode(String receiverExpressCode) {
        this.receiverExpressCode = receiverExpressCode;
    }

    /**
     * 获取收货人手机号码
     *
     * @return receiver_mobilephone - 收货人手机号码
     */
    public String getReceiverMobilephone() {
        return receiverMobilephone;
    }

    /**
     * 设置收货人手机号码
     *
     * @param receiverMobilephone 收货人手机号码
     */
    public void setReceiverMobilephone(String receiverMobilephone) {
        this.receiverMobilephone = receiverMobilephone;
    }

    /**
     * 获取收货人电话
     *
     * @return receiver_phone - 收货人电话
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * 设置收货人电话
     *
     * @param receiverPhone 收货人电话
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 获取省份
     *
     * @return receiver_province - 省份
     */
    public String getReceiverProvince() {
        return receiverProvince;
    }

    /**
     * 设置省份
     *
     * @param receiverProvince 省份
     */
    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    /**
     * 获取城市
     *
     * @return receiver_city - 城市
     */
    public String getReceiverCity() {
        return receiverCity;
    }

    /**
     * 设置城市
     *
     * @param receiverCity 城市
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /**
     * 获取县区
     *
     * @return receiver_county - 县区
     */
    public String getReceiverCounty() {
        return receiverCounty;
    }

    /**
     * 设置县区
     *
     * @param receiverCounty 县区
     */
    public void setReceiverCounty(String receiverCounty) {
        this.receiverCounty = receiverCounty;
    }

    /**
     * 获取产品信息备注
     *
     * @return product_comment - 产品信息备注
     */
    public String getProductComment() {
        return productComment;
    }

    /**
     * 设置产品信息备注
     *
     * @param productComment 产品信息备注
     */
    public void setProductComment(String productComment) {
        this.productComment = productComment;
    }

    /**
     * 获取另一备注
     *
     * @return another_product_comment - 另一备注
     */
    public String getAnotherProductComment() {
        return anotherProductComment;
    }

    /**
     * 设置另一备注
     *
     * @param anotherProductComment 另一备注
     */
    public void setAnotherProductComment(String anotherProductComment) {
        this.anotherProductComment = anotherProductComment;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", product=").append(product);
        sb.append(", model=").append(model);
        sb.append(", number=").append(number);
        sb.append(", unit=").append(unit);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", warehouseAddress=").append(warehouseAddress);
        sb.append(", combine=").append(combine);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", tableMakeTime=").append(tableMakeTime);
        sb.append(", customer=").append(customer);
        sb.append(", customerCode=").append(customerCode);
        sb.append(", customerPhone=").append(customerPhone);
        sb.append(", customerCompany=").append(customerCompany);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", cuType=").append(cuType);
        sb.append(", paymentAccount=").append(paymentAccount);
        sb.append(", saler=").append(saler);
        sb.append(", salerCode=").append(salerCode);
        sb.append(", salerPhone=").append(salerPhone);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", salerRemark=").append(salerRemark);
        sb.append(", receiver=").append(receiver);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", receiverExpressCode=").append(receiverExpressCode);
        sb.append(", receiverMobilephone=").append(receiverMobilephone);
        sb.append(", receiverPhone=").append(receiverPhone);
        sb.append(", receiverProvince=").append(receiverProvince);
        sb.append(", receiverCity=").append(receiverCity);
        sb.append(", receiverCounty=").append(receiverCounty);
        sb.append(", productComment=").append(productComment);
        sb.append(", anotherProductComment=").append(anotherProductComment);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}