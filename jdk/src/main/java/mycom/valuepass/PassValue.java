package mycom.valuepass;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PassValue {
    @Test
    public void test() {
        List<String> blockNumListNew = new ArrayList<>();
        getBlockList(blockNumListNew,"aa,bb");
        getBlockList(blockNumListNew,"cc,dd");
        getBlockList(blockNumListNew,"hh,ee");
        System.out.println(blockNumListNew);
    }

    public void getBlockList(List<String> blockNumListold, String blockNames){
        if (StringUtils.isNotBlank(blockNames)){
            String[] blockNums = blockNames.split(",");
            for (String blockNum:blockNums) {
                blockNumListold.add(blockNum);
            }
        }
    }
}
