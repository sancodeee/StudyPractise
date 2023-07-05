package com.ws.vo.result;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class ResultResp<T> {

    @NonNull
    private String code;

    @NonNull
    private String message;

    private T data;

    public static <T> ResultResp<T> SUCCESS(T data){
        ResultResp<T> resp = new ResultResp<>();
        resp.setCode("000");
        resp.setMessage("success");
        resp.setData(data);
        return resp;
    }

    public static <T> ResultResp<T> FAIL(String message){
        ResultResp<T> resp = new ResultResp<>();
        resp.setCode("999");
        resp.setMessage(message);
        return resp;
    }

    public static <T> ResultResp<T> FAIL(){
        ResultResp<T> resp = new ResultResp<>();
        resp.setCode("999");
        resp.setMessage("fail");
        return resp;
    }



}
