package com.ws.pojo;

import lombok.Data;

@Data
public class SIMCode {
    //电话号码
    private String telephoneNum;
    //验证码
    private String checkCode;
}
