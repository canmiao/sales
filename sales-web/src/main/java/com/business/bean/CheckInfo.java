package com.business.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_check")
public class CheckInfo implements Serializable {
    /**
     * 自增标识主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 外键，关联入库单
     */
    @Column(name = "input_id")
    private Long inputId;

    /**
     * 送检单号
     */
    @Column(name = "check_order")
    private String checkOrder;

    /**
     * 制表日期
     */
    @Column(name = "table_makedate")
    private Date tableMakedate;

    /**
     * 送检员
     */
    private String checker;

    /**
     * 联系电话
     */
    @Column(name = "checker_phone")
    private String checkerPhone;

    /**
     * 送检日期
     */
    @Column(name = "check_date")
    private Date checkDate;

    /**
     * 送检数量
     */
    @Column(name = "cheeck_number")
    private String cheeckNumber;

    /**
     * 供应商
     */
    private String provider;

    /**
     * 供应商联系电话
     */
    @Column(name = "provider_phone")
    private String providerPhone;

    /**
     * 送检类型
     */
    @Column(name = "check_type")
    private String checkType;

    /**
     * 送检规格
     */
    private String model;

    /**
     * 备注
     */
    private String note;

    /**
     * 送检产品名称
     */
    @Column(name = "produce_name")
    private String produceName;

    /**
     * 送检产品编号
     */
    @Column(name = "check_produce_number")
    private String checkProduceNumber;

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

    /**
     * 判定
     */
    private String judge;

    /**
     * 备注
     */
    @Column(name = "check_note")
    private String checkNote;

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
     * 获取外键，关联入库单
     *
     * @return input_id - 外键，关联入库单
     */
    public Long getInputId() {
        return inputId;
    }

    /**
     * 设置外键，关联入库单
     *
     * @param inputId 外键，关联入库单
     */
    public void setInputId(Long inputId) {
        this.inputId = inputId;
    }

    /**
     * 获取送检单号
     *
     * @return check_order - 送检单号
     */
    public String getCheckOrder() {
        return checkOrder;
    }

    /**
     * 设置送检单号
     *
     * @param checkOrder 送检单号
     */
    public void setCheckOrder(String checkOrder) {
        this.checkOrder = checkOrder;
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
     * 获取送检员
     *
     * @return checker - 送检员
     */
    public String getChecker() {
        return checker;
    }

    /**
     * 设置送检员
     *
     * @param checker 送检员
     */
    public void setChecker(String checker) {
        this.checker = checker;
    }

    /**
     * 获取联系电话
     *
     * @return checker_phone - 联系电话
     */
    public String getCheckerPhone() {
        return checkerPhone;
    }

    /**
     * 设置联系电话
     *
     * @param checkerPhone 联系电话
     */
    public void setCheckerPhone(String checkerPhone) {
        this.checkerPhone = checkerPhone;
    }

    /**
     * 获取送检日期
     *
     * @return check_date - 送检日期
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 设置送检日期
     *
     * @param checkDate 送检日期
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 获取送检数量
     *
     * @return cheeck_number - 送检数量
     */
    public String getCheeckNumber() {
        return cheeckNumber;
    }

    /**
     * 设置送检数量
     *
     * @param cheeckNumber 送检数量
     */
    public void setCheeckNumber(String cheeckNumber) {
        this.cheeckNumber = cheeckNumber;
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
     * 获取送检类型
     *
     * @return check_type - 送检类型
     */
    public String getCheckType() {
        return checkType;
    }

    /**
     * 设置送检类型
     *
     * @param checkType 送检类型
     */
    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    /**
     * 获取送检规格
     *
     * @return model - 送检规格
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置送检规格
     *
     * @param model 送检规格
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取送检产品名称
     *
     * @return produce_name - 送检产品名称
     */
    public String getProduceName() {
        return produceName;
    }

    /**
     * 设置送检产品名称
     *
     * @param produceName 送检产品名称
     */
    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    /**
     * 获取送检产品编号
     *
     * @return check_produce_number - 送检产品编号
     */
    public String getCheckProduceNumber() {
        return checkProduceNumber;
    }

    /**
     * 设置送检产品编号
     *
     * @param checkProduceNumber 送检产品编号
     */
    public void setCheckProduceNumber(String checkProduceNumber) {
        this.checkProduceNumber = checkProduceNumber;
    }

    /**
     * 获取抽样数量
     *
     * @return check_amount - 抽样数量
     */
    public String getCheckAmount() {
        return checkAmount;
    }

    /**
     * 设置抽样数量
     *
     * @param checkAmount 抽样数量
     */
    public void setCheckAmount(String checkAmount) {
        this.checkAmount = checkAmount;
    }

    /**
     * 获取检验情况
     *
     * @return check_result - 检验情况
     */
    public String getCheckResult() {
        return checkResult;
    }

    /**
     * 设置检验情况
     *
     * @param checkResult 检验情况
     */
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    /**
     * 获取不良数量
     *
     * @return bad_number - 不良数量
     */
    public String getBadNumber() {
        return badNumber;
    }

    /**
     * 设置不良数量
     *
     * @param badNumber 不良数量
     */
    public void setBadNumber(String badNumber) {
        this.badNumber = badNumber;
    }

    /**
     * 获取判定
     *
     * @return judge - 判定
     */
    public String getJudge() {
        return judge;
    }

    /**
     * 设置判定
     *
     * @param judge 判定
     */
    public void setJudge(String judge) {
        this.judge = judge;
    }

    /**
     * 获取备注
     *
     * @return check_note - 备注
     */
    public String getCheckNote() {
        return checkNote;
    }

    /**
     * 设置备注
     *
     * @param checkNote 备注
     */
    public void setCheckNote(String checkNote) {
        this.checkNote = checkNote;
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
        sb.append(", inputId=").append(inputId);
        sb.append(", checkOrder=").append(checkOrder);
        sb.append(", tableMakedate=").append(tableMakedate);
        sb.append(", checker=").append(checker);
        sb.append(", checkerPhone=").append(checkerPhone);
        sb.append(", checkDate=").append(checkDate);
        sb.append(", cheeckNumber=").append(cheeckNumber);
        sb.append(", provider=").append(provider);
        sb.append(", providerPhone=").append(providerPhone);
        sb.append(", checkType=").append(checkType);
        sb.append(", model=").append(model);
        sb.append(", note=").append(note);
        sb.append(", produceName=").append(produceName);
        sb.append(", checkProduceNumber=").append(checkProduceNumber);
        sb.append(", checkAmount=").append(checkAmount);
        sb.append(", checkResult=").append(checkResult);
        sb.append(", badNumber=").append(badNumber);
        sb.append(", judge=").append(judge);
        sb.append(", checkNote=").append(checkNote);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}