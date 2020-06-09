package com.business.dto;

import javax.persistence.Column;

/**
 * 存放入库单中提取出质检所需要的数据
 */
public class CheckInfoDTO {

    private Long InputId;

    /**
     * 数量
     */
    private Integer number;

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
     * 产品名称
     */
    private String name;


    public Long getInputId() {
        return InputId;
    }

    public void setInputId(Long inputId) {
        InputId = inputId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderPhone() {
        return providerPhone;
    }

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
