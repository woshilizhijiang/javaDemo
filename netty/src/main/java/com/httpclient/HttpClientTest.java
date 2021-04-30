package com.httpclient;

import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.nio.charset.Charset;
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
}
