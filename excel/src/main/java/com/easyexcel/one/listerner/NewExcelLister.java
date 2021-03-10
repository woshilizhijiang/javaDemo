package com.easyexcel.one.listerner;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.easyexcel.one.beans.PubCloudNetworkBean;

import java.util.ArrayList;
import java.util.List;

public class NewExcelLister extends AnalysisEventListener<PubCloudNetworkBean> {
    private List<PubCloudNetworkBean> list = new ArrayList<>();
    @Override
    public void invoke(PubCloudNetworkBean bean, AnalysisContext context) {
        list.add(bean);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        list.stream().forEach(bean -> {
            System.out.println(bean.getLocalSwitch());
            System.out.println(bean.getProviderSegId());
            System.out.println("*******************************************");
        });
        list.parallelStream();
    }
}
