package com.easyexcel.one;


import com.alibaba.excel.EasyExcel;
import com.easyexcel.one.beans.VmMemoryBean;
import com.easyexcel.one.listerner.ExcelListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DynamicAnalyse {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "D:\\10.112.229.150.xlsx";
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            EasyExcel.read(inputStream, VmMemoryBean.class,new ExcelListener()).sheet().doRead();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
