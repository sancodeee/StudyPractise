package com.ws.service;

public interface SimCodeService {

    String getCheckCode(String telephoneNum);

    boolean check(String telephoneNum,String checkCode);

}
