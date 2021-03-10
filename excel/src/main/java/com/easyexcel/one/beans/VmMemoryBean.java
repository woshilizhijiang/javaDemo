package com.easyexcel.one.beans;

import com.alibaba.excel.annotation.ExcelProperty;

public class VmMemoryBean {

    @ExcelProperty(value = "IP地址", index = 1)
    private String vmIP;
    @ExcelProperty(value = "物理机IP", index = 22)
    private String hostIP;
    @ExcelProperty(value = "内存（GB）", index = 5)
    private Integer cpuSize;

    public String getVmIP() {
        return vmIP;
    }

    public void setVmIP(String vmIP) {
        this.vmIP = vmIP;
    }

    public String getHostIP() {
        return hostIP;
    }

    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    public Integer getCpuSize() {
        return cpuSize;
    }

    public void setCpuSize(Integer cpuSize) {
        this.cpuSize = cpuSize;
    }
}


