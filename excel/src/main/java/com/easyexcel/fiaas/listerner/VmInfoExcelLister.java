package com.easyexcel.fiaas.listerner;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.easyexcel.fiaas.beans.VmInfoBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class VmInfoExcelLister extends AnalysisEventListener<VmInfoBean> {
    private List<VmInfoBean> list = new ArrayList<>();
    private Map<String,String> map = new HashMap<>();
    private AtomicInteger count = new AtomicInteger();
    @Override
    public void invoke(VmInfoBean data, AnalysisContext context) {
        count.incrementAndGet();
        map.put(data.getServerCode(), data.getProjectSimpleName());
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println(map.size());
        System.out.println(count);
    }
}
