package com.business.common;

/**
 *@Auther: ccm
 *@Description: 仓库状态常量
 *@Date: 2019/3/6 12:36
 */
public class InventoryConstant {

    public static final int ENOUGH = 10;

    public static final int NOT_ENOUGH = -10;

    /**
     * 默认销售状态
     */
    public static final int DEFAYLT_SALE_STATUS = 50;

    /**
     * 无库存
     */
    public static final int PRODUCT_IS_NULL = -1;


    /**
     * 仓库有货时销售单待审核状态
     */
    public static final int WAREHOUSE_ENOUGH_NOT_AUDIT = 51;

    /**
     *仓库无货时销售单待审核状态
     */
    public static final int WAREHOUSE_NO_ENOUGH_NOT_AUDIT = -51;

    /**
     * 销售主管已审核通过状态
     */
    public static final int WAREHOUSE_ENOUGH_PASS_AUDIT = 52;

    /**
     * 销售主管已审核未通过状态
     */
    public static final int WAREHOUSE_ENOUGH_NO_PASS_AUDIT = -52;

    /**
     * 仓库无货时销售单审核通过状态
     */
    public static final int WAREHOUSE_NO_ENOUGH_PASS_AUDIT = 53;

    /**
     * 仓库无货时销售单审核未通过状态
     */
    public static final int WAREHOUSE_NO_ENOUGH_NO_PASS_AUDIT = -53;

    /**
     * 采购单默认状态
     */
    public static final int DEFAYLT_PURCHASE_STATUS = 60;

    /**
     * 采购单审核通过状态
     */
    public static final int PURCHASE_PASS_AUDIT = 54;

    /**
     * 采购单审核未通过状态
     */
    public static final int PURCHASE_NOT_PASS_AUDIT = -54;

    /**
     * 在采购主管审核通过后供应商接单状态
     */
    public static final int PURCHASE_PASS_AUDIT_PROVIDER_TAKE_ORDER = 55;

    /**
     * 在采购主管审核通过后供应商未接单状态
     */
    public static final int PURCHASE_PASS_AUDIT_PROVIDER_REFUSE_ORDER = -55;

    /**
     * 供应商发货状态
     */
    public static final int PROVIDER_DELIVERY = 56;

    /**
     *供应商发货，仓库未收货状态
     */
    public static final int PURCHASE_NOT_RECEIVING_STATUS = 70;

    /**
     *库管收货未质检状态
     */
    public static final int INPUT_NOT_CHECK_STATUS = 57;

    /**
     *库管收货并且质检通过状态
     */
    public static final int INPUT_PASS_CHECE_STATUS = 58;

    /**
     *库管收货并且质检未通过状态
     */
    public static final int INPUT_NOT_PASS_CHECE_STATUS = -58;

    /**
     * 库管接单出现错误
     */
    public static final int INPUT_ERROR = -90;
}
