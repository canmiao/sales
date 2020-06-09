package com.business.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_input")
public class InputInfo implements Serializable {
    /**
     * 自增标识主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "purchase_id")
    private Long purchaseId;

    /**
     * 入库订单
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 入库单制作日期
     */
    @Column(name = "table_makedate")
    private Date tableMakedate;

    /**
     * 供应商
     */
    private String provider;

    /**
     * 供应商条码
     */
    @Column(name = "provider_code")
    private String providerCode;

    /**
     * 供应商联系电话
     */
    @Column(name = "provider_phone")
    private String providerPhone;

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
     * 入库员
     */
    @Column(name = "incoming_part")
    private String incomingPart;

    /**
     * 入库员联系电话
     */
    @Column(name = "incoming_part_phone")
    private String incomingPartPhone;

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
     * 入库类型
     */
    @Column(name = "input_type")
    private String inputType;

    /**
     * 仓库号
     */
    @Column(name = "warehouse_number")
    private String warehouseNumber;

    /**
     * 入库单备注
     */
    @Column(name = "input_note")
    private String inputNote;

    /**
     * 产品
     */
    private String product;

    /**
     * 型号
     */
    private String model;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 库位地址
     */
    private String address;

    /**
     * 合计
     */
    private Double combine;

    /**
     * 产品信息备注
     */
    @Column(name = "produce_note")
    private String produceNote;

    /**
     * 备注2
     */
    @Column(name = "another_note")
    private String anotherNote;

    /**
     * 审核
     */
    private String audit;

    /**
     * 记账
     */
    @Column(name = "keep_accounts")
    private String keepAccounts;

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
     * @return purchase_id
     */
    public Long getPurchaseId() {
        return purchaseId;
    }

    /**
     * @param purchaseId
     */
    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    /**
     * 获取入库订单
     *
     * @return order_number - 入库订单
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置入库订单
     *
     * @param orderNumber 入库订单
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取入库单制作日期
     *
     * @return table_makedate - 入库单制作日期
     */
    public Date getTableMakedate() {
        return tableMakedate;
    }

    /**
     * 设置入库单制作日期
     *
     * @param tableMakedate 入库单制作日期
     */
    public void setTableMakedate(Date tableMakedate) {
        this.tableMakedate = tableMakedate;
    }

    /**
     * 获取供应商
     *
     * @return provider - 供应商
     */
    public String getProvider() {
        return provider;
    }

    /**
     * 设置供应商
     *
     * @param provider 供应商
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * 获取供应商条码
     *
     * @return provider_code - 供应商条码
     */
    public String getProviderCode() {
        return providerCode;
    }

    /**
     * 设置供应商条码
     *
     * @param providerCode 供应商条码
     */
    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    /**
     * 获取供应商联系电话
     *
     * @return provider_phone - 供应商联系电话
     */
    public String getProviderPhone() {
        return providerPhone;
    }

    /**
     * 设置供应商联系电话
     *
     * @param providerPhone 供应商联系电话
     */
    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
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
     * 获取入库员
     *
     * @return incoming_part - 入库员
     */
    public String getIncomingPart() {
        return incomingPart;
    }

    /**
     * 设置入库员
     *
     * @param incomingPart 入库员
     */
    public void setIncomingPart(String incomingPart) {
        this.incomingPart = incomingPart;
    }

    /**
     * 获取入库员联系电话
     *
     * @return incoming_part_phone - 入库员联系电话
     */
    public String getIncomingPartPhone() {
        return incomingPartPhone;
    }

    /**
     * 设置入库员联系电话
     *
     * @param incomingPartPhone 入库员联系电话
     */
    public void setIncomingPartPhone(String incomingPartPhone) {
        this.incomingPartPhone = incomingPartPhone;
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
     * 获取入库类型
     *
     * @return input_type - 入库类型
     */
    public String getInputType() {
        return inputType;
    }

    /**
     * 设置入库类型
     *
     * @param inputType 入库类型
     */
    public void setInputType(String inputType) {
        this.inputType = inputType;
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
     * 获取入库单备注
     *
     * @return input_note - 入库单备注
     */
    public String getInputNote() {
        return inputNote;
    }

    /**
     * 设置入库单备注
     *
     * @param inputNote 入库单备注
     */
    public void setInputNote(String inputNote) {
        this.inputNote = inputNote;
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
     * 获取库位地址
     *
     * @return address - 库位地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置库位地址
     *
     * @param address 库位地址
     */
    public void setAddress(String address) {
        this.address = address;
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
     * 获取备注2
     *
     * @return another_note - 备注2
     */
    public String getAnotherNote() {
        return anotherNote;
    }

    /**
     * 设置备注2
     *
     * @param anotherNote 备注2
     */
    public void setAnotherNote(String anotherNote) {
        this.anotherNote = anotherNote;
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
     * @return keep_accounts - 记账
     */
    public String getKeepAccounts() {
        return keepAccounts;
    }

    /**
     * 设置记账
     *
     * @param keepAccounts 记账
     */
    public void setKeepAccounts(String keepAccounts) {
        this.keepAccounts = keepAccounts;
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
        sb.append(", purchaseId=").append(purchaseId);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", tableMakedate=").append(tableMakedate);
        sb.append(", provider=").append(provider);
        sb.append(", providerCode=").append(providerCode);
        sb.append(", providerPhone=").append(providerPhone);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", cuType=").append(cuType);
        sb.append(", payAccount=").append(payAccount);
        sb.append(", incomingPart=").append(incomingPart);
        sb.append(", incomingPartPhone=").append(incomingPartPhone);
        sb.append(", shippingDate=").append(shippingDate);
        sb.append(", deliveryRequirements=").append(deliveryRequirements);
        sb.append(", inputType=").append(inputType);
        sb.append(", warehouseNumber=").append(warehouseNumber);
        sb.append(", inputNote=").append(inputNote);
        sb.append(", product=").append(product);
        sb.append(", model=").append(model);
        sb.append(", number=").append(number);
        sb.append(", address=").append(address);
        sb.append(", combine=").append(combine);
        sb.append(", produceNote=").append(produceNote);
        sb.append(", anotherNote=").append(anotherNote);
        sb.append(", audit=").append(audit);
        sb.append(", keepAccounts=").append(keepAccounts);
        sb.append(", departmentHead=").append(departmentHead);
        sb.append(", controller=").append(controller);
        sb.append(", tableMaker=").append(tableMaker);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}