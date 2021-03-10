package com.signar;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.junit.Test;

/**
 * sigar查询系统信息需要 sigar-amd64-winnt.dll  放在C:\Windows\System32目录空了
 * no sigar-amd64-winnt.dll in java.library.path
 */
public class SignarTest {

    @Test
    public void memory() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        System.out.println(mem.getTotal()/1024/1024);
        System.out.println(mem.getFree()/1024/1024);

    }
}
