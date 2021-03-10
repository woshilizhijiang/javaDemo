package com.easyexcel.fiaas;

import com.alibaba.excel.EasyExcel;
import com.easyexcel.fiaas.beans.VmInfoBean;
import com.easyexcel.fiaas.listerner.VmInfoExcelLister;

public class ReadExcelFiaas {
    public static void main(String[] args) {
        String fileName1 = "F:\\fiaasmeterger\\server_1.xls";
        String fileName2 = "F:\\fiaasmeterger\\server_2.xls";
        String fileName3 = "F:\\fiaasmeterger\\server_3.xls";
        String fileName4 = "F:\\fiaasmeterger\\server_4.xls";
        String fileName5 = "F:\\fiaasmeterger\\server_5.xls";
        String fileName6 = "F:\\fiaasmeterger\\server_6.xls";
        VmInfoExcelLister vmInfoExcelLister = new VmInfoExcelLister();
        EasyExcel.read(fileName1, VmInfoBean.class,vmInfoExcelLister).sheet().doRead();
        EasyExcel.read(fileName2, VmInfoBean.class,vmInfoExcelLister).sheet().doRead();
        EasyExcel.read(fileName3, VmInfoBean.class,vmInfoExcelLister).sheet().doRead();
        EasyExcel.read(fileName4, VmInfoBean.class,vmInfoExcelLister).sheet().doRead();
        EasyExcel.read(fileName5, VmInfoBean.class,vmInfoExcelLister).sheet().doRead();
        EasyExcel.read(fileName6, VmInfoBean.class,vmInfoExcelLister).sheet().doRead();
    }
}
