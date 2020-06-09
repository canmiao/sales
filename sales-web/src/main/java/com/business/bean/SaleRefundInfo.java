package com.business.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sale_refund")
public class SaleRefundInfo implements Serializable {
    /**
     * 自增标识主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * 供应商
     */
    private String customer;

    /**
     * 供应商代码
     */
    @Column(name = "customer_code")
    private String customerCode;

    /**
     * 供应商联系电话
     */
    @Column(name = "customer_phone")
    private String customerPhone;

    /**
     * 退货员
     */
    @Column(name = "return_manber")
    private String returnManber;

    /**
     * 退货员联系电话
     */
    @Column(name = "return_manber_phone")
    private String returnManberPhone;

    /**
     * 收货日期
     */
    @Column(name = "receive_date")
    private Date receiveDate;

    /**
     * 退货日期
     */
    @Column(name = "sreturn_date")
    private Date sreturnDate;

    /**
     * 仓库号
     */
    @Column(name = "warehouse_number")
    private String warehouseNumber;

    /**
     * 退货原因
     */
    private String reasion;

    /**
     * 产品
     */
    private String product;

    /**
     * 名称
     */
    @Column(name = "produce_name")
    private String produceName;

    /**
     * 型号
     */
    private String model;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 单位
     */
    private String unit;

    /**
     * 单价
     */
    @Column(name = "unit_price")
    private Double unitPrice;

    /**
     * 库位地址
     */
    @Column(name = "warehouse_adress")
    private String warehouseAdress;

    /**
     * 合计
     */
    private Double combine;

    /**
     * 退货产品备注
     */
    @Column(name = "return_goods_note")
    private String returnGoodsNote;

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
     * 制单人
     */
    @Column(name = "table_maker")
    private String tableMaker;

    /**
     * 退货备注
     */
    @Column(name = "return_note")
    private String returnNote;

    /**
     * 另一备注
     */
    @Column(name = "another_return_note")
    private String anotherReturnNote;

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
     * 获取供应商
     *
     * @return customer - 供应商
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * 设置供应商
     *
     * @param customer 供应商
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * 获取供应商代码
     *
     * @return customer_code - 供应商代码
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * 设置供应商代码
     *
     * @param customerCode 供应商代码
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * 获取供应商联系电话
     *
     * @return customer_phone - 供应商联系电话
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * 设置供应商联系电话
     *
     * @param customerPhone 供应商联系电话
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * 获取退货员
     *
     * @return return_manber - 退货员
     */
    public String getReturnManber() {
        return returnManber;
    }

    /**
     * 设置退货员
     *
     * @param returnManber 退货员
     */
    public void setReturnManber(String returnManber) {
        this.returnManber = returnManber;
    }

    /**
     * 获取退货员联系电话
     *
     * @return return_manber_phone - 退货员联系电话
     */
    public String getReturnManberPhone() {
        return returnManberPhone;
    }

    /**
     * 设置退货员联系电话
     *
     * @param returnManberPhone 退货员联系电话
     */
    public void setReturnManberPhone(String returnManberPhone) {
        this.returnManberPhone = returnManberPhone;
    }

    /**
     * 获取收货日期
     *
     * @return receive_date - 收货日期
     */
    public Date getReceiveDate() {
        return receiveDate;
    }

    /**
     * 设置收货日期
     *
     * @param receiveDate 收货日期
     */
    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    /**
     * 获取退货日期
     *
     * @return sreturn_date - 退货日期
     */
    public Date getSreturnDate() {
        return sreturnDate;
    }

    /**
     * 设置退货日期
     *
     * @param sreturnDate 退货日期
     */
    public void setSreturnDate(Date sreturnDate) {
        this.sreturnDate = sreturnDate;
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
     * 获取退货原因
     *
     * @return reasion - 退货原因
     */
    public String getReasion() {
        return reasion;
    }

    /**
     * 设置退货原因
     *
     * @param reasion 退货原因
     */
    public void setReasion(String reasion) {
        this.reasion = reasion;
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
     * 获取名称
     *
     * @return produce_name - 名称
     */
    public String getProduceName() {
        return produceName;
    }

    /**
     * 设置名称
     *
     * @param produceName 名称
     */
    public void setProduceName(String produceName) {
        this.produceName = produceName;
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
     * 获取单价
     *
     * @return unit_price - 单价
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置单价
     *
     * @param unitPrice 单价
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 获取库位地址
     *
     * @return warehouse_adress - 库位地址
     */
    public String getWarehouseAdress() {
        return warehouseAdress;
    }

    /**
     * 设置库位地址
     *
     * @param warehouseAdress 库位地址
     */
    public void setWarehouseAdress(String warehouseAdress) {
        this.warehouseAdress = warehouseAdress;
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
     * 获取退货产品备注
     *
     * @return return_goods_note - 退货产品备注
     */
    public String getReturnGoodsNote() {
        return returnGoodsNote;
    }

    /**
     * 设置退货产品备注
     *
     * @param returnGoodsNote 退货产品备注
     */
    public void setReturnGoodsNote(String returnGoodsNote) {
        this.returnGoodsNote = returnGoodsNote;
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
     * 获取退货备注
     *
     * @return return_note - 退货备注
     */
    public String getReturnNote() {
        return returnNote;
    }

    /**
     * 设置退货备注
     *
     * @param returnNote 退货备注
     */
    public void setReturnNote(String returnNote) {
        this.returnNote = returnNote;
    }

    /**
     * 获取另一备注
     *
     * @return another_return_note - 另一备注
     */
    public String getAnotherReturnNote() {
        return anotherReturnNote;
    }

    /**
     * 设置另一备注
     *
     * @param anotherReturnNote 另一备注
     */
    public void setAnotherReturnNote(String anotherReturnNote) {
        this.anotherReturnNote = anotherReturnNote;
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
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", tableMakedate=").append(tableMakedate);
        sb.append(", customer=").append(customer);
        sb.append(", customerCode=").append(customerCode);
        sb.append(", customerPhone=").append(customerPhone);
        sb.append(", returnManber=").append(returnManber);
        sb.append(", returnManberPhone=").append(returnManberPhone);
        sb.append(", receiveDate=").append(receiveDate);
        sb.append(", sreturnDate=").append(sreturnDate);
        sb.append(", warehouseNumber=").append(warehouseNumber);
        sb.append(", reasion=").append(reasion);
        sb.append(", product=").append(product);
        sb.append(", produceName=").append(produceName);
        sb.append(", model=").append(model);
        sb.append(", number=").append(number);
        sb.append(", unit=").append(unit);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", warehouseAdress=").append(warehouseAdress);
        sb.append(", combine=").append(combine);
        sb.append(", returnGoodsNote=").append(returnGoodsNote);
        sb.append(", audit=").append(audit);
        sb.append(", keepAccount=").append(keepAccount);
        sb.append(", departmentHead=").append(departmentHead);
        sb.append(", tableMaker=").append(tableMaker);
        sb.append(", returnNote=").append(returnNote);
        sb.append(", anotherReturnNote=").append(anotherReturnNote);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}