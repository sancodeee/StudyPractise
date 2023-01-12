package com.ws.result.ENUM;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResponseCodes {

    SUCCESS(200,true,"成功",null);

    private final Integer code;
    private final Boolean success;
    private final String message;
    private final Object result;



}
