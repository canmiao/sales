package com.business.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_purchase")
public class PurchaseInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sale_id")
    private Long saleId;

    /**
     * 采购订单号
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 采购订单制表日期
     */
    @Column(name = "table_makedate")
    private Date tableMakedate;

    /**
     * 采购员
     */
    private String purchaseman;

    /**
     * 采购员条码
     */
    @Column(name = "purchaseman_code")
    private String purchasemanCode;

    /**
     * 采购员联系电话
     */
    @Column(name = "purchaseman_phone")
    private String purchasemanPhone;

    /**
     * 采购日期
     */
    @Column(name = "purchase_date")
    private Date purchaseDate;

    /**
     * 采购员备注
     */
    @Column(name = "purchase_note")
    private String purchaseNote;

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
     * 供应商联系人
     */
    @Column(name = "provider_linkman")
    private String providerLinkman;

    /**
     * 联系人电话
     */
    @Column(name = "provider_linkman_phone")
    private String providerLinkmanPhone;

    /**
     * 供应商地址
     */
    @Column(name = "provider_adress")
    private String providerAdress;

    /**
     * 产品编号
     */
    @Column(name = "produce_number")
    private String produceNumber;

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
     * 产品单位
     */
    private String unit;

    /**
     * 产品单价
     */
    @Column(name = "unit_price")
    private Double unitPrice;

    /**
     * 预计到货时间
     */
    @Column(name = "predict_goods_arrival_date")
    private Date predictGoodsArrivalDate;

    /**
     * 对应入库条码
     */
    @Column(name = "input_bar_code")
    private String inputBarCode;

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

    /**
     * 备注
     */
    private String note;

    /**
     * 另一备注
     */
    @Column(name = "another_note")
    private String anotherNote;

    /**
     * 采购收货地址
     */
    @Column(name = "purchase_receive_adress")
    private String purchaseReceiveAdress;

    /**
     * 结算方式
     */
    @Column(name = "clearing_form")
    private String clearingForm;

    /**
     * 含税率
     */
    @Column(name = "containing_rate")
    private Double containingRate;

    /**
     * 运输方式
     */
    @Column(name = "transportatino_way")
    private String transportatinoWay;

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
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return sale_id
     */
    public Long getSaleId() {
        return saleId;
    }

    /**
     * @param saleId
     */
    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    /**
     * 获取采购订单号
     *
     * @return order_number - 采购订单号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置采购订单号
     *
     * @param orderNumber 采购订单号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * 获取采购订单制表日期
     *
     * @return table_makedate - 采购订单制表日期
     */
    public Date getTableMakedate() {
        return tableMakedate;
    }

    /**
     * 设置采购订单制表日期
     *
     * @param tableMakedate 采购订单制表日期
     */
    public void setTableMakedate(Date tableMakedate) {
        this.tableMakedate = tableMakedate;
    }

    /**
     * 获取采购员
     *
     * @return purchaseman - 采购员
     */
    public String getPurchaseman() {
        return purchaseman;
    }

    /**
     * 设置采购员
     *
     * @param purchaseman 采购员
     */
    public void setPurchaseman(String purchaseman) {
        this.purchaseman = purchaseman;
    }

    /**
     * 获取采购员条码
     *
     * @return purchaseman_code - 采购员条码
     */
    public String getPurchasemanCode() {
        return purchasemanCode;
    }

    /**
     * 设置采购员条码
     *
     * @param purchasemanCode 采购员条码
     */
    public void setPurchasemanCode(String purchasemanCode) {
        this.purchasemanCode = purchasemanCode;
    }

    /**
     * 获取采购员联系电话
     *
     * @return purchaseman_phone - 采购员联系电话
     */
    public String getPurchasemanPhone() {
        return purchasemanPhone;
    }

    /**
     * 设置采购员联系电话
     *
     * @param purchasemanPhone 采购员联系电话
     */
    public void setPurchasemanPhone(String purchasemanPhone) {
        this.purchasemanPhone = purchasemanPhone;
    }

    /**
     * 获取采购日期
     *
     * @return purchase_date - 采购日期
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * 设置采购日期
     *
     * @param purchaseDate 采购日期
     */
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * 获取采购员备注
     *
     * @return purchase_note - 采购员备注
     */
    public String getPurchaseNote() {
        return purchaseNote;
    }

    /**
     * 设置采购员备注
     *
     * @param purchaseNote 采购员备注
     */
    public void setPurchaseNote(String purchaseNote) {
        this.purchaseNote = purchaseNote;
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
     * 获取供应商联系人
     *
     * @return provider_linkman - 供应商联系人
     */
    public String getProviderLinkman() {
        return providerLinkman;
    }

    /**
     * 设置供应商联系人
     *
     * @param providerLinkman 供应商联系人
     */
    public void setProviderLinkman(String providerLinkman) {
        this.providerLinkman = providerLinkman;
    }

    /**
     * 获取联系人电话
     *
     * @return provider_linkman_phone - 联系人电话
     */
    public String getProviderLinkmanPhone() {
        return providerLinkmanPhone;
    }

    /**
     * 设置联系人电话
     *
     * @param providerLinkmanPhone 联系人电话
     */
    public void setProviderLinkmanPhone(String providerLinkmanPhone) {
        this.providerLinkmanPhone = providerLinkmanPhone;
    }

    /**
     * 获取供应商地址
     *
     * @return provider_adress - 供应商地址
     */
    public String getProviderAdress() {
        return providerAdress;
    }

    /**
     * 设置供应商地址
     *
     * @param providerAdress 供应商地址
     */
    public void setProviderAdress(String providerAdress) {
        this.providerAdress = providerAdress;
    }

    /**
     * 获取产品编号
     *
     * @return produce_number - 产品编号
     */
    public String getProduceNumber() {
        return produceNumber;
    }

    /**
     * 设置产品编号
     *
     * @param produceNumber 产品编号
     */
    public void setProduceNumber(String produceNumber) {
        this.produceNumber = produceNumber;
    }

    /**
     * 获取产品名称
     *
     * @return produce_name - 产品名称
     */
    public String getProduceName() {
        return produceName;
    }

    /**
     * 设置产品名称
     *
     * @param produceName 产品名称
     */
    public void setProduceName(String produceName) {
        this.produceName = produceName;
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
     * 获取产品数量
     *
     * @return amount - 产品数量
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置产品数量
     *
     * @param amount 产品数量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
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
     * 获取预计到货时间
     *
     * @return predict_goods_arrival_date - 预计到货时间
     */
    public Date getPredictGoodsArrivalDate() {
        return predictGoodsArrivalDate;
    }

    /**
     * 设置预计到货时间
     *
     * @param predictGoodsArrivalDate 预计到货时间
     */
    public void setPredictGoodsArrivalDate(Date predictGoodsArrivalDate) {
        this.predictGoodsArrivalDate = predictGoodsArrivalDate;
    }

    /**
     * 获取对应入库条码
     *
     * @return input_bar_code - 对应入库条码
     */
    public String getInputBarCode() {
        return inputBarCode;
    }

    /**
     * 设置对应入库条码
     *
     * @param inputBarCode 对应入库条码
     */
    public void setInputBarCode(String inputBarCode) {
        this.inputBarCode = inputBarCode;
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
     * 获取采购产品合计
     *
     * @return purchase_produce_sum - 采购产品合计
     */
    public Double getPurchaseProduceSum() {
        return purchaseProduceSum;
    }

    /**
     * 设置采购产品合计
     *
     * @param purchaseProduceSum 采购产品合计
     */
    public void setPurchaseProduceSum(Double purchaseProduceSum) {
        this.purchaseProduceSum = purchaseProduceSum;
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
     * 获取采购收货地址
     *
     * @return purchase_receive_adress - 采购收货地址
     */
    public String getPurchaseReceiveAdress() {
        return purchaseReceiveAdress;
    }

    /**
     * 设置采购收货地址
     *
     * @param purchaseReceiveAdress 采购收货地址
     */
    public void setPurchaseReceiveAdress(String purchaseReceiveAdress) {
        this.purchaseReceiveAdress = purchaseReceiveAdress;
    }

    /**
     * 获取结算方式
     *
     * @return clearing_form - 结算方式
     */
    public String getClearingForm() {
        return clearingForm;
    }

    /**
     * 设置结算方式
     *
     * @param clearingForm 结算方式
     */
    public void setClearingForm(String clearingForm) {
        this.clearingForm = clearingForm;
    }

    /**
     * 获取含税率
     *
     * @return containing_rate - 含税率
     */
    public Double getContainingRate() {
        return containingRate;
    }

    /**
     * 设置含税率
     *
     * @param containingRate 含税率
     */
    public void setContainingRate(Double containingRate) {
        this.containingRate = containingRate;
    }

    /**
     * 获取运输方式
     *
     * @return transportatino_way - 运输方式
     */
    public String getTransportatinoWay() {
        return transportatinoWay;
    }

    /**
     * 设置运输方式
     *
     * @param transportatinoWay 运输方式
     */
    public void setTransportatinoWay(String transportatinoWay) {
        this.transportatinoWay = transportatinoWay;
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
        sb.append(", saleId=").append(saleId);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", tableMakedate=").append(tableMakedate);
        sb.append(", purchaseman=").append(purchaseman);
        sb.append(", purchasemanCode=").append(purchasemanCode);
        sb.append(", purchasemanPhone=").append(purchasemanPhone);
        sb.append(", purchaseDate=").append(purchaseDate);
        sb.append(", purchaseNote=").append(purchaseNote);
        sb.append(", provider=").append(provider);
        sb.append(", providerCode=").append(providerCode);
        sb.append(", providerLinkman=").append(providerLinkman);
        sb.append(", providerLinkmanPhone=").append(providerLinkmanPhone);
        sb.append(", providerAdress=").append(providerAdress);
        sb.append(", produceNumber=").append(produceNumber);
        sb.append(", produceName=").append(produceName);
        sb.append(", model=").append(model);
        sb.append(", amount=").append(amount);
        sb.append(", unit=").append(unit);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", predictGoodsArrivalDate=").append(predictGoodsArrivalDate);
        sb.append(", inputBarCode=").append(inputBarCode);
        sb.append(", warehouseAdress=").append(warehouseAdress);
        sb.append(", purchaseProduceSum=").append(purchaseProduceSum);
        sb.append(", note=").append(note);
        sb.append(", anotherNote=").append(anotherNote);
        sb.append(", purchaseReceiveAdress=").append(purchaseReceiveAdress);
        sb.append(", clearingForm=").append(clearingForm);
        sb.append(", containingRate=").append(containingRate);
        sb.append(", transportatinoWay=").append(transportatinoWay);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}