package com.ws.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ws.entity.LoginUserEntity;

public interface LoginUserService extends IService<LoginUserEntity> {

    boolean addUserInfo(LoginUserEntity loginUserEntity);

    LoginUserEntity findUserById(String id);

}
