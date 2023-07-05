package com.ws.service.impl;

import cn.hutool.jwt.JWT;
import com.sun.org.apache.xml.internal.security.algorithms.Algorithm;
import com.ws.entity.LoginUserEntity;
import com.ws.service.TokenService;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class TokenServiceImpl implements TokenService {

    public String getToken(LoginUserEntity user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getId()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
