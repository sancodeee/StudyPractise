package com.ws.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@Data
@ConfigurationProperties(prefix = "servers")
//开启数据校验
@Validated
public class ServerConfig {

    private String ipAddress;
    //设定校验规则，例如对port变量设定最大值校验
    @Max(value = 8888,message = "端口号最大不能超过8888")
    @Min(value = 100,message = "端口号最小值不能小于100")
    private int port ;
    private long timeout;

}
