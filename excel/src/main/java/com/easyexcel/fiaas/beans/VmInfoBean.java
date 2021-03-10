package com.easyexcel.fiaas.beans;

import com.alibaba.excel.annotation.ExcelProperty;

public class VmInfoBean {
    @ExcelProperty(value = "ID", index=20)
    private String serverCode;
    @ExcelProperty(value = "名称", index=0)
    private String projectSimpleName;
    @ExcelProperty(value = "逻辑机房", index=11)
    private String ldcName;
    @ExcelProperty(value = "环境类型", index=9)
    private String envType;
    @ExcelProperty(value = "IP地址", index=1)
    private String serverIp;
    @ExcelProperty(value = "CPU（核数）", index=4)
    private String cpuNum;
    @ExcelProperty(value = "内存（GB）", index=5)
    private String mes;
    @ExcelProperty(value = "物理机IP", index=22)
    private String hostIP;
    @ExcelProperty(value = "状态", index=3)
    private String status;
    @ExcelProperty(value = "创建时间", index=16)
    private String createTime;
    @ExcelProperty(value = "更新时间", index=17)
    private String updateTime;




    public String getServerCode() {
        return serverCode;
    }

    public void setServerCode(String serverCode) {
        this.serverCode = serverCode;
    }

    public String getProjectSimpleName() {
        return projectSimpleName;
    }

    public void setProjectSimpleName(String projectSimpleName) {
        this.projectSimpleName = projectSimpleName;
    }

    public String getLdcName() {
        return ldcName;
    }

    public void setLdcName(String ldcName) {
        this.ldcName = ldcName;
    }

    public String getEnvType() {
        return envType;
    }

    public void setEnvType(String envType) {
        this.envType = envType;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getCpuNum() {
        return cpuNum;
    }

    public void setCpuNum(String cpuNum) {
        this.cpuNum = cpuNum;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getHostIP() {
        return hostIP;
    }

    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
