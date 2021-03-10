package mycom.utils.fastjson;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * Created by 20013649 on 2020/6/22.
 */
public class Pp<T> {
    public Results<T> call(String jsons){
        TypeReference<Results<T>> typeReference = new TypeReference<Results<T>>(){};
        return JSON.parseObject(jsons, typeReference);
    }

    private <T> Results<T> parseResultV2(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, new TypeReference<Results<T>>(clazz) {
        });
    }

}
