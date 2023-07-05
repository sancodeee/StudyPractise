package com.ws.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ws.dao.LoginUserDAO;
import com.ws.entity.LoginUserEntity;
import com.ws.service.LoginUserService;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl extends ServiceImpl<LoginUserDAO, LoginUserEntity> implements LoginUserService {

    @Override
    public boolean addUserInfo(LoginUserEntity loginUserEntity) {
        return getBaseMapper().insert(loginUserEntity) > 1;
    }



}
