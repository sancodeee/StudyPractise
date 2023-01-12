package com.ws.result;

import com.ws.result.ENUM.ResponseCodes;
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

    public ResponseResult readSuccessful(){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ResponseCodes.SUCCESS.getCode());
        responseResult.setSuccess(ResponseCodes.SUCCESS.getSuccess());
        responseResult.setResult(ResponseCodes.SUCCESS.getResult());
        responseResult.setMessage(ResponseCodes.SUCCESS.getMessage());
        return responseResult;
    }

}
