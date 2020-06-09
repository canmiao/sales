package com.business.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_output")
public class OutputInfo implements Serializable {
    /**
     * 自增标识主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "saleinfo_id")
    private Long saleinfoId;

    /**
     * 订单号
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 制表日期
     */
    @Column(name = "table_makedate")
    private Date tableMakedate;

    /**
     * 客户
     */
    private String customer;

    /**
     * 客户代码
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
    @Column(name = "payment_method")
    private String paymentMethod;

    /**
     * 币种
     */
    @Column(name = "cu_type")
    private String cuType;

    /**
     * 客户付款账户
     */
    @Column(name = "pay_account")
    private String payAccount;

    /**
     * 出货员
     */
    @Column(name = "delivery_member")
    private String deliveryMember;

    /**
     * 出货员联系电话
     */
    @Column(name = "delivery_member_phone")
    private String deliveryMemberPhone;

    /**
     * 出货日期
     */
    @Column(name = "shipping_date")
    private Date shippingDate;

    /**
     * 交期要求
     */
    @Column(name = "delivery_requirements")
    private String deliveryRequirements;

    /**
     * 出货类型
     */
    @Column(name = "outbound_type")
    private String outboundType;

    /**
     * 仓库号
     */
    @Column(name = "warehouse_number")
    private String warehouseNumber;

    /**
     * 备注
     */
    @Column(name = "customer_note")
    private String customerNote;

    /**
     * 货品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 型号
     */
    private String model;

    /**
     * 批号
     */
    @Column(name = "batch_number")
    private String batchNumber;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 单位
     */
    private String unit;

    /**
     * 折扣
     */
    private String discount;

    /**
     * 折后
     */
    @Column(name = "after_discount")
    private String afterDiscount;

    /**
     * 产品信息备注
     */
    @Column(name = "produce_note")
    private String produceNote;

    /**
     * 另一备注
     */
    @Column(name = "another_produce_note")
    private String anotherProduceNote;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货地址
     */
    @Column(name = "shipping_adress")
    private String shippingAdress;

    /**
     * 收货邮编
     */
    @Column(name = "receiving_zip_code")
    private String receivingZipCode;

    /**
     * 收货人手机
     */
    @Column(name = "receiver_mobile_phone")
    private String receiverMobilePhone;

    /**
     * 收货人电话
     */
    @Column(name = "receiver_phone")
    private String receiverPhone;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 审核
     */
    private String audit;

    /**
     * 记账
     */
    @Column(name = "keep_account")
    private String keepAccount;

    /**
     * 部门主管
     */
    @Column(name = "department_head")
    private String departmentHead;

    /**
     * 报管员
     */
    private String controller;

    /**
     * 制单人
     */
    @Column(name = "table_maker")
    private String tableMaker;

    /**
     * 销售主管
     */
    @Column(name = "sales_director")
    private String salesDirector;

    /**
     * 销售员
     */
    private String salesman;

    /**
     * 配送车号
     */
    @Column(name = "car_number")
    private String carNumber;

    /**
     * 配送员
     */
    private String deliver;

    /**
     * 收货员
     */
    private String receiver;

    /**
     * 县区
     */
    private String county;

    /**
     * 状态
     */
    private String status;

    /**
     * 创造时间
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
     * @return saleinfo_id
     */
    public Long getSaleinfoId() {
        return saleinfoId;
    }

    /**
     * @param saleinfoId
     */
    public void setSaleinfoId(Long saleinfoId) {
        this.saleinfoId = saleinfoId;
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
     * @return table_makedate - 制表日期
     */
    public Date getTableMakedate() {
        return tableMakedate;
    }

    /**
     * 设置制表日期
     *
     * @param tableMakedate 制表日期
     */
    public void setTableMakedate(Date tableMakedate) {
        this.tableMakedate = tableMakedate;
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
     * 获取客户代码
     *
     * @return customer_code - 客户代码
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * 设置客户代码
     *
     * @param customerCode 客户代码
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
     * @return payment_method - 付款方式
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * 设置付款方式
     *
     * @param paymentMethod 付款方式
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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
     * 获取客户付款账户
     *
     * @return pay_account - 客户付款账户
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * 设置客户付款账户
     *
     * @param payAccount 客户付款账户
     */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    /**
     * 获取出货员
     *
     * @return delivery_member - 出货员
     */
    public String getDeliveryMember() {
        return deliveryMember;
    }

    /**
     * 设置出货员
     *
     * @param deliveryMember 出货员
     */
    public void setDeliveryMember(String deliveryMember) {
        this.deliveryMember = deliveryMember;
    }

    /**
     * 获取出货员联系电话
     *
     * @return delivery_member_phone - 出货员联系电话
     */
    public String getDeliveryMemberPhone() {
        return deliveryMemberPhone;
    }

    /**
     * 设置出货员联系电话
     *
     * @param deliveryMemberPhone 出货员联系电话
     */
    public void setDeliveryMemberPhone(String deliveryMemberPhone) {
        this.deliveryMemberPhone = deliveryMemberPhone;
    }

    /**
     * 获取出货日期
     *
     * @return shipping_date - 出货日期
     */
    public Date getShippingDate() {
        return shippingDate;
    }

    /**
     * 设置出货日期
     *
     * @param shippingDate 出货日期
     */
    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    /**
     * 获取交期要求
     *
     * @return delivery_requirements - 交期要求
     */
    public String getDeliveryRequirements() {
        return deliveryRequirements;
    }

    /**
     * 设置交期要求
     *
     * @param deliveryRequirements 交期要求
     */
    public void setDeliveryRequirements(String deliveryRequirements) {
        this.deliveryRequirements = deliveryRequirements;
    }

    /**
     * 获取出货类型
     *
     * @return outbound_type - 出货类型
     */
    public String getOutboundType() {
        return outboundType;
    }

    /**
     * 设置出货类型
     *
     * @param outboundType 出货类型
     */
    public void setOutboundType(String outboundType) {
        this.outboundType = outboundType;
    }

    /**
     * 获取仓库号
     *
     * @return warehouse_number - 仓库号
     */
    public String getWarehouseNumber() {
        return warehouseNumber;
    }

    /**
     * 设置仓库号
     *
     * @param warehouseNumber 仓库号
     */
    public void setWarehouseNumber(String warehouseNumber) {
        this.warehouseNumber = warehouseNumber;
    }

    /**
     * 获取备注
     *
     * @return customer_note - 备注
     */
    public String getCustomerNote() {
        return customerNote;
    }

    /**
     * 设置备注
     *
     * @param customerNote 备注
     */
    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    /**
     * 获取货品名称
     *
     * @return goods_name - 货品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置货品名称
     *
     * @param goodsName 货品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取型号
     *
     * @return model - 型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置型号
     *
     * @param model 型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取批号
     *
     * @return batch_number - 批号
     */
    public String getBatchNumber() {
        return batchNumber;
    }

    /**
     * 设置批号
     *
     * @param batchNumber 批号
     */
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    /**
     * 获取数量
     *
     * @return number - 数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置数量
     *
     * @param number 数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取单位
     *
     * @return unit - 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置单位
     *
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取折扣
     *
     * @return discount - 折扣
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * 设置折扣
     *
     * @param discount 折扣
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * 获取折后
     *
     * @return after_discount - 折后
     */
    public String getAfterDiscount() {
        return afterDiscount;
    }

    /**
     * 设置折后
     *
     * @param afterDiscount 折后
     */
    public void setAfterDiscount(String afterDiscount) {
        this.afterDiscount = afterDiscount;
    }

    /**
     * 获取产品信息备注
     *
     * @return produce_note - 产品信息备注
     */
    public String getProduceNote() {
        return produceNote;
    }

    /**
     * 设置产品信息备注
     *
     * @param produceNote 产品信息备注
     */
    public void setProduceNote(String produceNote) {
        this.produceNote = produceNote;
    }

    /**
     * 获取另一备注
     *
     * @return another_produce_note - 另一备注
     */
    public String getAnotherProduceNote() {
        return anotherProduceNote;
    }

    /**
     * 设置另一备注
     *
     * @param anotherProduceNote 另一备注
     */
    public void setAnotherProduceNote(String anotherProduceNote) {
        this.anotherProduceNote = anotherProduceNote;
    }

    /**
     * 获取收货人
     *
     * @return consignee - 收货人
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * 设置收货人
     *
     * @param consignee 收货人
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * 获取收货地址
     *
     * @return shipping_adress - 收货地址
     */
    public String getShippingAdress() {
        return shippingAdress;
    }

    /**
     * 设置收货地址
     *
     * @param shippingAdress 收货地址
     */
    public void setShippingAdress(String shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    /**
     * 获取收货邮编
     *
     * @return receiving_zip_code - 收货邮编
     */
    public String getReceivingZipCode() {
        return receivingZipCode;
    }

    /**
     * 设置收货邮编
     *
     * @param receivingZipCode 收货邮编
     */
    public void setReceivingZipCode(String receivingZipCode) {
        this.receivingZipCode = receivingZipCode;
    }

    /**
     * 获取收货人手机
     *
     * @return receiver_mobile_phone - 收货人手机
     */
    public String getReceiverMobilePhone() {
        return receiverMobilePhone;
    }

    /**
     * 设置收货人手机
     *
     * @param receiverMobilePhone 收货人手机
     */
    public void setReceiverMobilePhone(String receiverMobilePhone) {
        this.receiverMobilePhone = receiverMobilePhone;
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
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取审核
     *
     * @return audit - 审核
     */
    public String getAudit() {
        return audit;
    }

    /**
     * 设置审核
     *
     * @param audit 审核
     */
    public void setAudit(String audit) {
        this.audit = audit;
    }

    /**
     * 获取记账
     *
     * @return keep_account - 记账
     */
    public String getKeepAccount() {
        return keepAccount;
    }

    /**
     * 设置记账
     *
     * @param keepAccount 记账
     */
    public void setKeepAccount(String keepAccount) {
        this.keepAccount = keepAccount;
    }

    /**
     * 获取部门主管
     *
     * @return department_head - 部门主管
     */
    public String getDepartmentHead() {
        return departmentHead;
    }

    /**
     * 设置部门主管
     *
     * @param departmentHead 部门主管
     */
    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    /**
     * 获取报管员
     *
     * @return controller - 报管员
     */
    public String getController() {
        return controller;
    }

    /**
     * 设置报管员
     *
     * @param controller 报管员
     */
    public void setController(String controller) {
        this.controller = controller;
    }

    /**
     * 获取制单人
     *
     * @return table_maker - 制单人
     */
    public String getTableMaker() {
        return tableMaker;
    }

    /**
     * 设置制单人
     *
     * @param tableMaker 制单人
     */
    public void setTableMaker(String tableMaker) {
        this.tableMaker = tableMaker;
    }

    /**
     * 获取销售主管
     *
     * @return sales_director - 销售主管
     */
    public String getSalesDirector() {
        return salesDirector;
    }

    /**
     * 设置销售主管
     *
     * @param salesDirector 销售主管
     */
    public void setSalesDirector(String salesDirector) {
        this.salesDirector = salesDirector;
    }

    /**
     * 获取销售员
     *
     * @return salesman - 销售员
     */
    public String getSalesman() {
        return salesman;
    }

    /**
     * 设置销售员
     *
     * @param salesman 销售员
     */
    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    /**
     * 获取配送车号
     *
     * @return car_number - 配送车号
     */
    public String getCarNumber() {
        return carNumber;
    }

    /**
     * 设置配送车号
     *
     * @param carNumber 配送车号
     */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    /**
     * 获取配送员
     *
     * @return deliver - 配送员
     */
    public String getDeliver() {
        return deliver;
    }

    /**
     * 设置配送员
     *
     * @param deliver 配送员
     */
    public void setDeliver(String deliver) {
        this.deliver = deliver;
    }

    /**
     * 获取收货员
     *
     * @return receiver - 收货员
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 设置收货员
     *
     * @param receiver 收货员
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 获取县区
     *
     * @return county - 县区
     */
    public String getCounty() {
        return county;
    }

    /**
     * 设置县区
     *
     * @param county 县区
     */
    public void setCounty(String county) {
        this.county = county;
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
     * 获取创造时间
     *
     * @return create_time - 创造时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创造时间
     *
     * @param createTime 创造时间
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
        sb.append(", saleinfoId=").append(saleinfoId);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", tableMakedate=").append(tableMakedate);
        sb.append(", customer=").append(customer);
        sb.append(", customerCode=").append(customerCode);
        sb.append(", customerPhone=").append(customerPhone);
        sb.append(", customerCompany=").append(customerCompany);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", cuType=").append(cuType);
        sb.append(", payAccount=").append(payAccount);
        sb.append(", deliveryMember=").append(deliveryMember);
        sb.append(", deliveryMemberPhone=").append(deliveryMemberPhone);
        sb.append(", shippingDate=").append(shippingDate);
        sb.append(", deliveryRequirements=").append(deliveryRequirements);
        sb.append(", outboundType=").append(outboundType);
        sb.append(", warehouseNumber=").append(warehouseNumber);
        sb.append(", customerNote=").append(customerNote);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", model=").append(model);
        sb.append(", batchNumber=").append(batchNumber);
        sb.append(", number=").append(number);
        sb.append(", unit=").append(unit);
        sb.append(", discount=").append(discount);
        sb.append(", afterDiscount=").append(afterDiscount);
        sb.append(", produceNote=").append(produceNote);
        sb.append(", anotherProduceNote=").append(anotherProduceNote);
        sb.append(", consignee=").append(consignee);
        sb.append(", shippingAdress=").append(shippingAdress);
        sb.append(", receivingZipCode=").append(receivingZipCode);
        sb.append(", receiverMobilePhone=").append(receiverMobilePhone);
        sb.append(", receiverPhone=").append(receiverPhone);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", audit=").append(audit);
        sb.append(", keepAccount=").append(keepAccount);
        sb.append(", departmentHead=").append(departmentHead);
        sb.append(", controller=").append(controller);
        sb.append(", tableMaker=").append(tableMaker);
        sb.append(", salesDirector=").append(salesDirector);
        sb.append(", salesman=").append(salesman);
        sb.append(", carNumber=").append(carNumber);
        sb.append(", deliver=").append(deliver);
        sb.append(", receiver=").append(receiver);
        sb.append(", county=").append(county);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}