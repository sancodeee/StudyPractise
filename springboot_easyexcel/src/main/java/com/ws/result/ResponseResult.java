package com.ws.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {

    private Integer code;
    private Boolean success;
    private String message;
    private Object result;

    public ResponseResult(Integer code , Boolean success,String message){
            this.code = code;
            this.success = success;
            this.message = message;
    }

    public ResponseResult(Integer code,String message){
            this.code = code;
            this.message = message;
    }

    public ResponseResult (Integer code , String message , Object result){
            this.code = code;
            this.message = message;
            this.result = result;
    }

}
