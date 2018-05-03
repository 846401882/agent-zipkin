package com.zipkin.demo.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private OkHttpClient client;

    private Random random = new Random();

    @RequestMapping("s1")
    public String s1() throws InterruptedException, IOException {
        int sleep= random.nextInt(100);
        TimeUnit.MILLISECONDS.sleep(sleep);
        Request request = new Request.Builder().url("http://localhost:9092/s2").get().build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        request = new Request.Builder().url("http://localhost:9093/s3").get().build();  //service4
        response = client.newCall(request).execute();
        result += response.body().string();
        return " [service1 sleep " + sleep+" ms]" + result;
    }

}