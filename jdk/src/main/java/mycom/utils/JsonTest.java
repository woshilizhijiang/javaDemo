package mycom.utils;

import mycom.utils.fastjson.Man;
import mycom.utils.fastjson.Pp;
import mycom.utils.fastjson.Results;

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
}
