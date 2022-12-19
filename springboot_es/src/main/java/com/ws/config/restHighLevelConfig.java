package com.ws.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class restHighLevelConfig {
//
//    //旧版本通过配置类将es客户端对象交给给springboot管理 新版本已实现自动注入
//    @Bean
//    public RestHighLevelClient restHighLevelClient(){
//        return new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
//    }
//
//}
