package com.business.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_purchase_retund")
public class PurchaseRetundInfo implements Serializable {
    /**
     * 自增标识主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_id")
    private Long checkId;

    /**
     * 采购退货订单号
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
    private String provider;

    /**
     * 供应商代码
     */
    @Column(name = "provider_code")
    private String providerCode;

    /**
     * 供应商联系电话
     */
    @Column(name = "provider_phone")
    private String providerPhone;

    /**
     * 退货员
     */
    @Column(name = "return_man")
    private String returnMan;

    /**
     * 退货员联系电话
     */
    @Column(name = "return_man_phone")
    private String returnManPhone;

    /**
     * 退货日期
     */
    @Column(name = "return_date")
    private Date returnDate;

    /**
     * 预收货日期
     */
    @Column(name = "predict_receive_time")
    private Date predictReceiveTime;

    /**
     * 仓库号
     */
    @Column(name = "warehouse_number")
    private String warehouseNumber;

    /**
     * 退货原因
     */
    @Column(name = "return_reasion")
    private String returnReasion;

    /**
     * 退货备注
     */
    @Column(name = "return_note")
    private String returnNote;

    /**
     * 退货产品
     */
    @Column(name = "return_produce")
    private String returnProduce;

    /**
     * 退货产品型号
     */
    @Column(name = "return_produce_model")
    private String returnProduceModel;

    /**
     * 退货产品数量
     */
    @Column(name = "return_produce_amount")
    private Integer returnProduceAmount;

    /**
     * 退货产品单位
     */
    @Column(name = "return_produce_unit")
    private String returnProduceUnit;

    /**
     * 退货产品单价
     */
    @Column(name = "return_produce_unit_price")
    private Double returnProduceUnitPrice;

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
    @Column(name = "return_produce_note")
    private String returnProduceNote;

    /**
     * 另一备注
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
    @Column(name = "modigy_time")
    private Date modigyTime;

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
     * @return check_id
     */
    public Long getCheckId() {
        return checkId;
    }

    /**
     * @param checkId
     */
    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    /**
     * 获取采购退货订单号
     *
     * @return order_number - 采购退货订单号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置采购退货订单号
     *
     * @param orderNumber 采购退货订单号
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
     * 获取供应商代码
     *
     * @return provider_code - 供应商代码
     */
    public String getProviderCode() {
        return providerCode;
    }

    /**
     * 设置供应商代码
     *
     * @param providerCode 供应商代码
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
     * 获取退货员
     *
     * @return return_man - 退货员
     */
    public String getReturnMan() {
        return returnMan;
    }

    /**
     * 设置退货员
     *
     * @param returnMan 退货员
     */
    public void setReturnMan(String returnMan) {
        this.returnMan = returnMan;
    }

    /**
     * 获取退货员联系电话
     *
     * @return return_man_phone - 退货员联系电话
     */
    public String getReturnManPhone() {
        return returnManPhone;
    }

    /**
     * 设置退货员联系电话
     *
     * @param returnManPhone 退货员联系电话
     */
    public void setReturnManPhone(String returnManPhone) {
        this.returnManPhone = returnManPhone;
    }

    /**
     * 获取退货日期
     *
     * @return return_date - 退货日期
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * 设置退货日期
     *
     * @param returnDate 退货日期
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * 获取预收货日期
     *
     * @return predict_receive_time - 预收货日期
     */
    public Date getPredictReceiveTime() {
        return predictReceiveTime;
    }

    /**
     * 设置预收货日期
     *
     * @param predictReceiveTime 预收货日期
     */
    public void setPredictReceiveTime(Date predictReceiveTime) {
        this.predictReceiveTime = predictReceiveTime;
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
     * @return return_reasion - 退货原因
     */
    public String getReturnReasion() {
        return returnReasion;
    }

    /**
     * 设置退货原因
     *
     * @param returnReasion 退货原因
     */
    public void setReturnReasion(String returnReasion) {
        this.returnReasion = returnReasion;
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
     * 获取退货产品
     *
     * @return return_produce - 退货产品
     */
    public String getReturnProduce() {
        return returnProduce;
    }

    /**
     * 设置退货产品
     *
     * @param returnProduce 退货产品
     */
    public void setReturnProduce(String returnProduce) {
        this.returnProduce = returnProduce;
    }

    /**
     * 获取退货产品型号
     *
     * @return return_produce_model - 退货产品型号
     */
    public String getReturnProduceModel() {
        return returnProduceModel;
    }

    /**
     * 设置退货产品型号
     *
     * @param returnProduceModel 退货产品型号
     */
    public void setReturnProduceModel(String returnProduceModel) {
        this.returnProduceModel = returnProduceModel;
    }

    /**
     * 获取退货产品数量
     *
     * @return return_produce_amount - 退货产品数量
     */
    public Integer getReturnProduceAmount() {
        return returnProduceAmount;
    }

    /**
     * 设置退货产品数量
     *
     * @param returnProduceAmount 退货产品数量
     */
    public void setReturnProduceAmount(Integer returnProduceAmount) {
        this.returnProduceAmount = returnProduceAmount;
    }

    /**
     * 获取退货产品单位
     *
     * @return return_produce_unit - 退货产品单位
     */
    public String getReturnProduceUnit() {
        return returnProduceUnit;
    }

    /**
     * 设置退货产品单位
     *
     * @param returnProduceUnit 退货产品单位
     */
    public void setReturnProduceUnit(String returnProduceUnit) {
        this.returnProduceUnit = returnProduceUnit;
    }

    /**
     * 获取退货产品单价
     *
     * @return return_produce_unit_price - 退货产品单价
     */
    public Double getReturnProduceUnitPrice() {
        return returnProduceUnitPrice;
    }

    /**
     * 设置退货产品单价
     *
     * @param returnProduceUnitPrice 退货产品单价
     */
    public void setReturnProduceUnitPrice(Double returnProduceUnitPrice) {
        this.returnProduceUnitPrice = returnProduceUnitPrice;
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
     * @return return_produce_note - 退货产品备注
     */
    public String getReturnProduceNote() {
        return returnProduceNote;
    }

    /**
     * 设置退货产品备注
     *
     * @param returnProduceNote 退货产品备注
     */
    public void setReturnProduceNote(String returnProduceNote) {
        this.returnProduceNote = returnProduceNote;
    }

    /**
     * 获取另一备注
     *
     * @return another_note - 另一备注
     */
    public String getAnotherNote() {
        return anotherNote;
    }

    /**
     * 设置另一备注
     *
     * @param anotherNote 另一备注
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
     * @return modigy_time - 修改时间
     */
    public Date getModigyTime() {
        return modigyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modigyTime 修改时间
     */
    public void setModigyTime(Date modigyTime) {
        this.modigyTime = modigyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", checkId=").append(checkId);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", tableMakedate=").append(tableMakedate);
        sb.append(", provider=").append(provider);
        sb.append(", providerCode=").append(providerCode);
        sb.append(", providerPhone=").append(providerPhone);
        sb.append(", returnMan=").append(returnMan);
        sb.append(", returnManPhone=").append(returnManPhone);
        sb.append(", returnDate=").append(returnDate);
        sb.append(", predictReceiveTime=").append(predictReceiveTime);
        sb.append(", warehouseNumber=").append(warehouseNumber);
        sb.append(", returnReasion=").append(returnReasion);
        sb.append(", returnNote=").append(returnNote);
        sb.append(", returnProduce=").append(returnProduce);
        sb.append(", returnProduceModel=").append(returnProduceModel);
        sb.append(", returnProduceAmount=").append(returnProduceAmount);
        sb.append(", returnProduceUnit=").append(returnProduceUnit);
        sb.append(", returnProduceUnitPrice=").append(returnProduceUnitPrice);
        sb.append(", warehouseAdress=").append(warehouseAdress);
        sb.append(", combine=").append(combine);
        sb.append(", returnProduceNote=").append(returnProduceNote);
        sb.append(", anotherNote=").append(anotherNote);
        sb.append(", audit=").append(audit);
        sb.append(", keepAccount=").append(keepAccount);
        sb.append(", departmentHead=").append(departmentHead);
        sb.append(", tableMaker=").append(tableMaker);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modigyTime=").append(modigyTime);
        sb.append("]");
        return sb.toString();
    }
}