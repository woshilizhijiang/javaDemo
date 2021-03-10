package com.easyexcel.one.listerner;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.easyexcel.one.beans.VmMemoryBean;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ExcelListener extends AnalysisEventListener<VmMemoryBean> {

    private AtomicInteger atomicInteger = new AtomicInteger();
    private List<VmMemoryBean> list = new ArrayList<>();

    @Override
    public void invoke(VmMemoryBean vmMemoryBean, AnalysisContext context) {

        list.add(vmMemoryBean);
    }

    /**
     * 表中数据单位为MB
     * numaHostBean根据宿主机0，1代表NUMA；numa0 , numa1；
     * 预留内存
     * N0 = (N/8192 – 3.5) * 350 + 2048 + 12188  = 0.043*N + 13111
     * N1 = (N/8192 – 0.5 ) * 350 + 2048 = 0.043*N + 1873
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        list.stream().collect(Collectors.groupingBy(VmMemoryBean::getHostIP)).forEach((hostIP, vmMemoryBeans)->{
            Map<String,Integer> threshold = new HashMap<>();
            threshold.put(hostIP,111);
            String hostBackup = hostIP+"_backup";
            threshold.put(hostBackup,121);
            List<VmMemoryBean> sortedNumaVmBeans = vmMemoryBeans.stream()
                    .sorted(Comparator.comparing(VmMemoryBean::getCpuSize).reversed())
                    .collect(Collectors.toList());

            sortedNumaVmBeans.forEach(vmMemoryBean -> {
                if (threshold.get(hostBackup)-threshold.get(hostIP) >= 0){
                    int sumReduce = threshold.get(hostBackup) - vmMemoryBean.getCpuSize();
                    if (sumReduce >= 0){
                        threshold.put(hostBackup,sumReduce);
                    }else {
                        atomicInteger.incrementAndGet();
                        System.out.println("宿主机 " + hostIP + " 拆分为两个服务器:Nuam0 111G， Numa1 121G，冗余无法安装虚机 : "
                                + vmMemoryBean.getVmIP() + " ：" + vmMemoryBean.getCpuSize() + "GB");
                        System.out.println("宿主机剩余空间 Numa0：" +  threshold.get(hostIP) + "GB"
                                + " ，宿主机剩余空间 Numa1：" +  threshold.get(hostIP+"_backup") + "GB" +
                                "，宿主机已使用空间：" +  (232-threshold.get(hostIP)-threshold.get(hostIP+"_backup")) + "GB");
                    }
                }else {
                    int sumBackReduce = threshold.get(hostIP) - vmMemoryBean.getCpuSize();
                    if (sumBackReduce >= 0){
                        threshold.put(hostIP,sumBackReduce);
                    }else {
                        atomicInteger.incrementAndGet();
                        System.out.println("宿主机 " + hostIP + " 拆分为两个服务器:Nuam0 111G， Numa1 121G，冗余无法安装虚机 : "
                                + vmMemoryBean.getVmIP() + " ：" + vmMemoryBean.getCpuSize() + "GB");
                        System.out.println("宿主机剩余空间 Numa0：" +  threshold.get(hostIP) + "GB"
                                + " ，宿主机剩余空间 Numa1：" +  threshold.get(hostIP+"_backup") + "GB" +
                                "，宿主机已使用空间：" +  (232-threshold.get(hostIP)-threshold.get(hostIP+"_backup")) + "GB");
                    }
                }
            });
        });
        System.out.println("无法分配机器数量： " +  atomicInteger.get());
    }
}
