package com.httpclient;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HttpClientTest {
    public static void main(String[] args) throws Exception {
//        String responseStr = Request.Get("http://localhost:8082/simulation/doSimulationTmp")
//                .connectTimeout(100000)
//                .socketTimeout(100000)
//                .execute()
//                .returnContent().asString();
//        System.out.println(responseStr);
        Object obj = new Object();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,2,0L, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(4));
        for (int i = 0; i < 6; i++) {
            poolExecutor.execute(()->{
                String responseStr = null;
                try {
                    responseStr = Executor.newInstance()
                            .execute(Request.Get("http://localhost:8082/simulation/doSimulationTmp"))
                            .returnContent()
                            .asString(Charset.forName("UTF-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(responseStr);
            });
        }
        while (Thread.currentThread().isAlive()){
            System.out.println(Thread.currentThread().getState());
        }
    }
    @Test
    public void tt(){
        List<Integer> ipList = new ArrayList<>();
        ipList.add(1);
        ipList.add(2);
        ipList.add(3);
        ipList.add(4);
        ipList.add(5);

        ipList.stream().filter(it->it>2).forEach(System.out::println);


    }



    @Test
    public void testVm(){
        String json = "{\"appKey\":\"${appKey}\",\"appId\":\"${appId}\",\"metricId\":\"${metricId}\",\"startDate\":\"${startDate}\",\"endDate\":\"${endDate}\"," +
                "\"ldc\":\"${ldc}\",\"filters\":{\"AND\":{\"AND\":[{\"value\":[\"${ip}\"],\"key\":\"ip\",\"operator\":\"IN\"}]}},\"group\":\"\",\"unit\":\"\"}";

        String appKey = "59920732cd3a43f28e48f8f42514da5a";
        String appId = "FIAAS";
        String metricId = "435";
        String startDate = "2021-06-02 01:05:51";
        String endDate = "2021-06-02 01:05:51";
        String ldc = "NJYH";
        String ip  = "10.230.72.2";
        String request = json.replace("${appKey}",appKey).replace("${metricId}",metricId).replace("${ldc}",ldc)
                .replace("${appId}",appId).replace("${startDate}",startDate).replace("${endDate}",endDate).replace("${ip}",ip);
        String promesUrl = "http://ctmodp.cnsuning.com/api/services/metrics";
        System.out.println(request);
        System.out.println("**************************************************");

        System.out.println(httpFluentPost(promesUrl,request));

    }



    @Test
    public void testHost(){
        String json = "{\"appKey\":\"${appKey}\",\"appId\":\"${appId}\",\"metricId\":\"${metricId}\",\"startDate\":\"${startDate}\",\"endDate\":\"${endDate}\"," +
                "\"ldc\":\"${ldc}\",\"filters\":{\"AND\":{\"AND\":[{\"value\":[\"${ip}\"],\"key\":\"ip\",\"operator\":\"IN\"}]}},\"group\":\"\",\"unit\":\"\"}";

        String appKey = "59920732cd3a43f28e48f8f42514da5a";
        String appId = "FIAAS";
        String metricId = "468";
        String startDate = "2021-06-02 01:05:51";
        String endDate = "2021-06-02 01:05:51";
        String ldc = "NJYH";
        String ip  = "10.112.204.78";
        String request = json.replace("${appKey}",appKey).replace("${metricId}",metricId).replace("${ldc}",ldc)
                .replace("${appId}",appId).replace("${startDate}",startDate).replace("${endDate}",endDate).replace("${ip}",ip);
        String promesUrl = "http://ctmodp.cnsuning.com/api/services/metrics";
        System.out.println(request);
        System.out.println("**************************************************");

        System.out.println(httpFluentPost(promesUrl,request));

    }

    public static String getIps(){

        return "";
    }

    @Test
    public void resultConvert(){
        String result = "{\"code\":1,\"message\":\"成功\",\"data\":{\"data\":{\"columns\":[{\"name\":\"time\",\"type\":\"\"},{\"name\":\"value\",\"type\":\"\"},{\"name\":\"exported_ip\",\"type\":\"\"},{\"name\":\"instance\",\"type\":\"\"},{\"name\":\"cpuid\",\"type\":\"\"},{\"name\":\"ldcId\",\"type\":\"\"},{\"name\":\"ip\",\"type\":\"\"},{\"name\":\"env\",\"type\":\"\"},{\"name\":\"firstCenterName\",\"type\":\"\"},{\"name\":\"type\",\"type\":\"\"},{\"name\":\"collectUrl\",\"type\":\"\"},{\"name\":\"slave\",\"type\":\"\"},{\"name\":\"exporter\",\"type\":\"\"},{\"name\":\"hostname\",\"type\":\"\"},{\"name\":\"appId\",\"type\":\"\"},{\"name\":\"job\",\"type\":\"\"},{\"name\":\"secondCenterName\",\"type\":\"\"}],\"rows\":[[1621829550,0.76,\"10.112.200.152\",\"10.112.200.152:8000\",\"cpu\",\"NJYH\",\"10.112.200.152\",\"PRD\",\"基础云研发中心\",\"idle\",\"http://10.112.200.152:8000/metrics\",\"10.105.236.30\",\"indicators_exporter\",\"jbo02n010112200152.sncloud.com\",\"OPENSTACK\",\"standard\",\"存储产品研发中心\"]]}}}";
        JSONObject response = JSONObject.parseObject(result);
        double rateDouble = response.getJSONObject("data").getJSONObject("data").getJSONArray("rows").getJSONArray(0).getDouble(1) * 100;
        System.out.println(rateDouble);
    }

    public static String httpFluentPost(String promesUrl, String request) {
        String result = "";
        try {
            result = Executor.newInstance()
                    .execute(Request.Post(promesUrl).bodyString(request, ContentType.APPLICATION_JSON))
                    .returnContent()
                    .asString(Charset.defaultCharset());
            return result;
        } catch (IOException e) {
            return result;
        }finally {
            Executor.closeIdleConnections();
        }
    }


    /**
     * 集群平均容量
     */
    @Test
    public void hostRate(){
        String json = "{\"appKey\":\"${appKey}\",\"appId\":\"${appId}\",\"metricId\":\"${metricId}\",\"startDate\":\"${startDate}\",\"endDate\":\"${endDate}\"," +
                "\"ldc\":\"${ldc}\",\"filters\":{\"AND\":{\"AND\":[{\"value\":[${ip}],\"key\":\"ip\",\"operator\":\"IN\"}]}},\"group\":\"\",\"unit\":\"\"}";
        //物理机ip集群
        String ip = "\"10.112.200.60\",\"10.112.200.72\",\"10.112.200.75\",\"10.112.200.92\",\"10.112.200.105\",\"10.112.200.129\",\"10.112.201.157\",\"10.112.201.156\",\"10.112.201.187\",\"10.112.201.204\",\"10.112.201.216\",\"10.112.201.218\",\"10.112.200.12\",\"10.112.200.11\",\"10.112.200.13\",\"10.112.200.14\",\"10.112.200.16\",\"10.112.200.15\",\"10.112.200.17\",\"10.112.200.18\",\"10.112.200.19\",\"10.112.200.21\",\"10.112.200.22\",\"10.112.200.20\",\"10.112.200.23\",\"10.112.200.24\",\"10.112.200.25\",\"10.112.200.26\",\"10.112.200.27\",\"10.112.200.29\",\"10.112.200.28\",\"10.112.200.30\",\"10.112.200.31\",\"10.112.200.32\",\"10.112.200.34\",\"10.112.200.33\",\"10.112.200.35\",\"10.112.200.36\",\"10.112.200.37\",\"10.112.200.38\",\"10.112.200.39\",\"10.112.200.40\",\"10.112.200.43\",\"10.112.200.41\",\"10.112.200.42\",\"10.112.200.44\",\"10.112.200.46\",\"10.112.200.45\",\"10.112.200.47\",\"10.112.200.49\",\"10.112.200.50\",\"10.112.200.48\",\"10.112.200.52\",\"10.112.200.53\",\"10.112.200.51\",\"10.112.200.81\",\"10.112.200.83\",\"10.112.200.82\",\"10.112.200.85\",\"10.112.200.84\",\"10.112.200.87\",\"10.112.200.86\",\"10.112.200.88\",\"10.112.200.89\",\"10.112.200.90\",\"10.112.200.136\",\"10.112.200.137\",\"10.112.200.139\",\"10.112.200.138\",\"10.112.200.140\",\"10.112.200.142\",\"10.112.200.141\",\"10.112.200.144\",\"10.112.200.143\",\"10.112.200.145\",\"10.112.200.146\",\"10.112.200.147\",\"10.112.200.148\",\"10.112.200.149\",\"10.112.200.150\",\"10.112.200.151\",\"10.112.200.153\",\"10.112.200.152\",\"10.112.200.154\",\"10.112.200.155\",\"10.112.200.158\",\"10.112.200.156\",\"10.112.200.157\",\"10.112.200.161\",\"10.112.200.159\",\"10.112.200.162\",\"10.112.200.160\",\"10.112.200.164\",\"10.112.200.163\",\"10.112.200.165\",\"10.112.200.167\",\"10.112.200.170\",\"10.112.200.172\",\"10.112.200.166\",\"10.112.200.168\",\"10.112.200.182\",\"10.112.200.169\",\"10.112.200.171\",\"10.112.200.185\",\"10.112.200.181\",\"10.112.200.177\",\"10.112.200.174\",\"10.112.200.176\",\"10.112.200.183\",\"10.112.200.184\",\"10.112.200.180\",\"10.112.200.178\",\"10.112.200.179\",\"10.112.200.175\",\"10.112.200.186\",\"10.112.200.187\",\"10.112.200.188\",\"10.112.200.189\",\"10.112.200.190\",\"10.112.200.191\",\"10.112.200.192\",\"10.112.200.193\",\"10.112.200.194\",\"10.112.200.195\",\"10.112.200.198\",\"10.112.200.199\",\"10.112.200.202\",\"10.112.200.201\",\"10.112.200.200\",\"10.112.200.209\",\"10.112.200.212\",\"10.112.200.210\",\"10.112.200.211\",\"10.112.200.197\",\"10.112.200.207\",\"10.112.200.208\",\"10.112.200.213\",\"10.112.200.214\",\"10.112.200.196\",\"10.112.201.23\",\"10.112.201.25\",\"10.112.201.26\",\"10.112.201.27\",\"10.112.201.28\",\"10.112.201.30\",\"10.112.201.29\",\"10.112.201.31\",\"10.112.201.32\",\"10.112.201.34\",\"10.112.201.35\",\"10.112.201.33\",\"10.112.201.36\",\"10.112.201.37\",\"10.112.201.40\",\"10.112.201.39\",\"10.112.201.38\",\"10.112.201.42\",\"10.112.201.41\",\"10.112.201.24\",\"10.112.201.43\",\"10.112.201.44\",\"10.112.201.45\",\"10.112.201.46\",\"10.112.201.48\",\"10.112.201.47\",\"10.112.201.49\",\"10.112.201.50\",\"10.112.201.52\",\"10.112.201.51\",\"10.112.201.53\",\"10.112.201.55\",\"10.112.201.54\",\"10.112.201.58\",\"10.112.201.57\",\"10.112.201.56\",\"10.112.201.60\",\"10.112.201.59\",\"10.112.201.61\",\"10.112.201.62\",\"10.112.201.65\",\"10.112.201.64\",\"10.112.201.66\",\"10.112.201.63\",\"10.112.201.67\",\"10.112.201.68\",\"10.112.201.69\",\"10.112.201.71\",\"10.112.201.70\",\"10.112.201.72\",\"10.112.201.73\",\"10.112.201.74\",\"10.112.201.79\",\"10.112.201.78\",\"10.112.201.80\",\"10.112.201.81\",\"10.112.201.75\",\"10.112.201.76\",\"10.112.201.77\",\"10.112.201.82\",\"10.112.201.83\",\"10.112.201.84\",\"10.112.201.85\",\"10.112.201.86\",\"10.112.201.87\",\"10.112.201.89\",\"10.112.201.88\",\"10.112.201.90\",\"10.112.201.91\",\"10.112.201.92\",\"10.112.201.93\",\"10.112.201.94\",\"10.112.201.97\",\"10.112.201.96\",\"10.112.201.95\",\"10.112.201.98\",\"10.112.201.99\",\"10.112.201.100\",\"10.112.201.101\",\"10.112.201.102\",\"10.112.201.104\",\"10.112.201.103\",\"10.112.201.105\",\"10.112.201.106\",\"10.112.201.107\",\"10.112.201.108\",\"10.112.201.110\",\"10.112.201.109\",\"10.112.201.112\",\"10.112.201.111\",\"10.112.201.113\",\"10.112.201.115\",\"10.112.201.114\",\"10.112.201.116\",\"10.112.201.119\",\"10.112.201.118\",\"10.112.201.120\",\"10.112.201.117\",\"10.112.201.121\",\"10.112.201.122\",\"10.112.201.124\",\"10.112.201.123\",\"10.112.201.127\",\"10.112.201.125\",\"10.112.201.128\",\"10.112.201.129\",\"10.112.201.131\",\"10.112.201.132\",\"10.112.201.133\",\"10.112.201.130\",\"10.112.201.134\",\"10.112.201.138\",\"10.112.201.136\",\"10.112.201.135\",\"10.112.201.137\",\"10.112.201.139\",\"10.112.201.143\",\"10.112.201.140\",\"10.112.201.141\",\"10.112.201.142\",\"10.112.201.145\",\"10.112.201.144\",\"10.112.201.126\",\"10.112.201.146\",\"10.112.201.147\",\"10.112.201.148\",\"10.112.201.149\",\"10.112.201.150\",\"10.112.201.151\",\"10.112.201.153\",\"10.112.201.152\",\"10.112.201.154\",\"10.112.201.219\",\"10.112.201.220\",\"10.112.201.221\",\"10.112.201.222\",\"10.112.201.223\",\"10.112.201.225\",\"10.112.201.226\",\"10.112.201.224\",\"10.112.201.227\",\"10.112.201.228\",\"10.112.201.229\",\"10.112.201.230\",\"10.112.201.231\",\"10.112.201.233\",\"10.112.201.234\",\"10.112.201.235\",\"10.112.201.237\",\"10.112.201.238\",\"10.112.201.236\",\"10.112.201.239\",\"10.112.201.240\",\"10.112.201.232\",\"10.112.201.242\",\"10.112.201.241\",\"10.112.201.243\",\"10.112.201.244\",\"10.112.201.245\",\"10.112.201.246\",\"10.112.201.248\",\"10.112.201.247\",\"10.112.201.249\",\"10.112.201.250\",\"10.112.201.251\",\"10.112.201.253\",\"10.112.201.254\",\"10.112.201.255\",\"10.112.202.0\",\"10.112.202.1\",\"10.112.202.2\",\"10.112.202.3\",\"10.112.201.252\",\"10.112.202.5\",\"10.112.202.7\",\"10.112.202.6\",\"10.112.202.9\",\"10.112.202.8\",\"10.112.202.10\",\"10.112.202.11\",\"10.112.202.12\",\"10.112.202.13\",\"10.112.202.14\",\"10.112.202.15\",\"10.112.202.17\",\"10.112.202.16\",\"10.112.202.18\",\"10.112.202.19\",\"10.112.202.20\",\"10.112.202.21\",\"10.112.202.22\",\"10.112.202.23\",\"10.112.202.25\",\"10.112.202.24\",\"10.112.202.26\",\"10.112.202.28\",\"10.112.202.27\",\"10.112.202.29\",\"10.112.202.30\",\"10.112.202.31\",\"10.112.202.33\",\"10.112.202.34\",\"10.112.202.35\",\"10.112.202.36\",\"10.112.202.38\",\"10.112.202.37\",\"10.112.202.41\",\"10.112.202.39\",\"10.112.202.42\",\"10.112.202.40\",\"10.112.202.43\",\"10.112.202.45\",\"10.112.202.44\",\"10.112.202.46\",\"10.112.202.47\",\"10.112.202.48\",\"10.112.202.49\",\"10.112.202.50\",\"10.112.202.70\"";

        String appKey = "59920732cd3a43f28e48f8f42514da5a";
        String appId = "FIAAS";
        String metricId = "468";
        String startDate = "2021-06-02 01:05:51";
        String endDate = "2021-06-02 01:05:51";
        String ldc = "NJYH";

        String request = json.replace("${appKey}",appKey).replace("${metricId}",metricId).replace("${ldc}",ldc)
                .replace("${appId}",appId).replace("${startDate}",startDate).replace("${endDate}",endDate).replace("${ip}",ip);
        String promesUrl = "http://ctmodp.cnsuning.com/api/services/metrics";
        System.out.println("**************************************************");
        Long start = System.currentTimeMillis();

        System.out.println(getHostCpuRateMap2(httpFluentPost(promesUrl,request)));
        Long end = System.currentTimeMillis()-start;
        System.out.println("耗时 ： " + end + " ms。");
    }

    public static String getHostCpuRateMap2(String hostResult){
        JSONObject response = JSONObject.parseObject(hostResult);
        double avg = 0L;
        double sum = 0L;
        int size = 0;
        JSONObject data1 = response.getJSONObject("data");
        if (null != data1){
            JSONObject data2 = data1.getJSONObject("data");
            if (null != data2){
                JSONArray rows = data2.getJSONArray("rows");
                if (null != rows){
                    size = rows.size();
                    for (int i = 0; i < size; i++) {
                        sum += rows.getJSONArray(i).getDouble(1) * 100;
                    }
                }
            }
        }
        avg = sum/size;
        System.out.println("avg : " + avg + "%");
        String rst = String.format( "%4.2f", avg);
        System.out.println("rst : " + rst + "%");
        return rst + "%";
    }

}
