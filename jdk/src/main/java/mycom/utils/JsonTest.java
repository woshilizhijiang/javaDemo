package mycom.utils;

import mycom.utils.fastjson.Man;
import mycom.utils.fastjson.Pp;
import mycom.utils.fastjson.Results;
import org.junit.Test;

import java.util.List;

/**
 * Created by 20013649 on 2020/6/22.
 */
public class JsonTest {
    public static void main(String[] args){
        Pp<List<Man>> listPp = new Pp<List<Man>>(){};
        String data = "{\"data\":[{\"name\":\"aaa\",\"pass\":\"bb\"},{\"name\":\"2aa\",\"pass\":\"2bb\"}]}";
        System.out.println(data);
        Results<List<Man>> call = listPp.call(data);
        call.getData().forEach(System.out::println);
    }

    @Test
    public void test(){
        String json = "{\"appKey\":\"${appKey}\",\"appId\":\"${appId}\",\"metricId\":\"${metricId}\",\"startDate\":\"${startDate}\",\"endDate\":\"${endDate}\"," +
                "\"ldc\":\"${ldc}\",\"filters\":{\"AND\":{\"AND\":[{\"value\":[\"${ip}\"],\"key\":\"ip\",\"operator\":\"IN\"}]}},\"group\":\"\",\"unit\":\"\"}";

        String appKey = "38b99c318cdb4ed18b233b4fb49d4750";
        String appId = "FIAAS";
        String metricId = "560";
        String date = "2021-05-24 12:12:30";
        String ldc = "NJYH";
        String ip  = "10.112.200.152";
        String result = json.replace("${appKey}",appKey).replace("${metricId}",metricId).replace("${ldc}",ldc)
                .replace("${appId}",appId).replace("${startDate}",date).replace("${endDate}",date).replace("${ip}",ip);
        System.out.println(result);
    }
}
