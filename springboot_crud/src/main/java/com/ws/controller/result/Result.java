package com.ws.controller.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Boolean success;
    private Object result;
    private String msg;

    public Result(Boolean success){
        this.success = success;
    }

    public Result(Boolean success, String msg){
        this.success = success;
        this.msg = msg;
    }

    public Result(Boolean success, Object result){
        this.success = success;
        this.result = result;
    }

    public Result(Object result){
        this.result = result;
    }


}
