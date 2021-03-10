package com.easyexcel.one;

import com.alibaba.excel.EasyExcel;
import com.easyexcel.one.beans.VmMemoryBean;
import com.easyexcel.one.listerner.ExcelListener;

public class ExcelAnalyseDemo {
    public static void main(String[] args) {
        String fileName = "D:\\JBGXYG_SRIOV_ALL.xlsx";
        EasyExcel.read(fileName, VmMemoryBean.class,new ExcelListener()).sheet().doRead();
//
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(fileName);
//            EasyExcel.read(inputStream, PubCloudNetworkBean.class,new NewExcelLister()).sheet().doRead();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
