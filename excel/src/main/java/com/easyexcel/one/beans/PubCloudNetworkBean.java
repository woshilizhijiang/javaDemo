package com.easyexcel.one.beans;

import com.alibaba.excel.annotation.ExcelProperty;

public class PubCloudNetworkBean {
    @ExcelProperty(value = "集群（英文）", index=0)
    private String localSwitch;
    
    @ExcelProperty(value = "子网id", index=1)
    private String networkId;

    @ExcelProperty(value = "Vlanid", index=2)
    private String providerSegId;

    @ExcelProperty(value = "独占系统简称", index=3)
    private String simpleName;

    public String getLocalSwitch() {
        return localSwitch;
    }

    public void setLocalSwitch(String localSwitch) {
        this.localSwitch = localSwitch;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getProviderSegId() {
        return providerSegId;
    }

    public void setProviderSegId(String providerSegId) {
        this.providerSegId = providerSegId;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }
}
