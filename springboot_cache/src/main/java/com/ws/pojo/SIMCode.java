package com.ws.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SIMCode implements Serializable {

    private static final long serialVersionUID = 6755302909068928784L;

    //电话号码
    private String telephoneNum;
    //验证码
    private String checkCode;
}
