import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmTmp {
    public static void main(String[] args) {
//        BigDecimal lowRate = new BigDecimal(0.2);
//        System.out.println(lowRate);
        setSpecType2cpuUnavailable(new HashMap<String,Object>(),4,4,
                12,12,"24.00","12","0.2","60");
    }

    private static void setSpecType2cpuUnavailable(Map<String, Object> param, int core, int memory
            , int cpuUnused, int memoryUnused, String capTotal, String capUsed, String cpuRate, String cpuHostRate){
        int cpuSpecNum = cpuUnused/core;
        int memSpecNum = memoryUnused/memory;
//        int capSpecNum = (int)((Double.valueOf(capTotal)-Double.valueOf(capUsed)) * Double.valueOf(cpuHostRate) / (core * Double.valueOf(cpuRate))/100);
        double available = Double.valueOf(capTotal) * Double.valueOf(cpuHostRate)/100;
        System.out.println(available);
        int capSpecNum = (int)((available -Double.valueOf(capUsed))/ (core * Double.valueOf(cpuRate)));
        System.out.println(capSpecNum);
        int tmp = Math.min(capSpecNum,memSpecNum);
        int specNum = Math.min(cpuSpecNum,tmp);
        int cpuUnavailable = cpuUnused - specNum*core;
        int memoryUnavailable = memoryUnused - specNum*memory;
        param.put("specNumbers",specNum);
        param.put("cpuUnavailable",cpuUnavailable);
        param.put("memoryUnavailable",memoryUnavailable);
    }
}
