package com.business.common;

/**
 * @Author: taoye
 * @Description:
 * @Date: 10:46 2018/8/13
 */
public class CodeConstant {
    /**
     * 成功
     */
    public static final int SUCCESS = 1;


    /**
     * 失败
     */
    public static final int ERROR = -1;

    /**
     * 冲突
     */
    public static final int CONFLICT = 2;

    /**
     * 更新失败! 请刷新页面后再试
     */
    public static final int UPDATE_FAIL_VERSION = -2;

    /**
     * 警告
     */
    public static final int WARN = -3;

    /**
     * 参数错误
     */
    public static final int ERROR_PARAMETER = -1000;

    /**
     * 信息不存在
     */
    public static final int NOT_EXIST = -1001;

    /**
     * 信息已经存在
     */
    public static final int ALREADY_EXIST = -1002;

    /**
     * 已经绑定
     */
    public static final int ALREADY_BIND = -10;

    /**
     * 库中无此采购记录
     */
    public static final int NO_SUCH_PURCHASEINFO = -150;


    /**
     * 无此出库记录
     */
    public static final int NO_SUCH_OUTPUTINFO = -151;


    /**
     * 无此质检记录
     */
    public static final int NO_SUCH_CHECKINFO = -152;


    /**
     * 无此入库记录
     */
    public static final int NO_SUCH_INPUTINFO = -153;


    /**
     * 未查到采购信息
     */
    public static final int NO_PURCHASE_INFORMATION = -154;


    /**
     * 无此采购退货记录
     */
    public static final int NO_SUCH_PURCHASE_RETUND_INFO = -155;

    /**
     * 无此销售退货记录
     */
    public static final int NO_SUCH_SALE_REFUND_INFO = -156;

    /**
     * 无此销售记录
     */
    public static final int NO_SUCH_SALE_INFO = -157;
}
