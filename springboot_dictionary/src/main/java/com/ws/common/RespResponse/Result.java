package com.ws.common.RespResponse;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class Result<T> {

    private Boolean success;
    private T result;
    private String msg;

    //查询成功统一响应体
    public static<T> Result<T> queryOk(T result){
        Result<T> r = new Result<>();
        r.setSuccess(true)
                .setMsg("查询成功！")
                .setResult(result);
        return r;
    }

    public static<T> Result<T> queryFail(T result){
        Result<T> r = new Result<>();
        r.setSuccess(true)
                .setMsg("查询失败！")
                .setResult(result);
        return r;
    }

    //插入成功统一响应体
    public static<T> Result<T> insertOk(T result){
        Result<T> r = new Result<>();
        r.setSuccess(true)
                .setMsg("插入成功！")
                .setResult(result);
        return r;
    }

    public static<T> Result<T> insertOk(){
        Result<T> r = new Result<>();
        r.setSuccess(true)
                .setMsg("插入成功！")
                .setResult(null);
        return r;
    }

    public static<T> Result<T> insertFail(T result){
        Result<T> r = new Result<>();
        r.setSuccess(true)
                .setMsg("插入失败！")
                .setResult(result);
        return r;
    }

    public static<T> Result<T> updateOk(){
        Result<T> r = new Result<>();
        r.setSuccess(true)
                .setMsg("更新成功！")
                .setResult(null);
        return r;
    }

    public static<T> Result<T> updateOk(T result){
        Result<T> r = new Result<>();
        r.setSuccess(true).setMsg("更新成功！").setResult(result);
        return r;
    }

    public static<T> Result<T> updateFail(T result){
        Result<T> r = new Result<>();
        r.setSuccess(true).setMsg("更新失败！").setResult(result);
        return r;
    }

    public static<T> Result<T> deleteOk(Integer id){
        Result<T> r = new Result<>();
        r.setSuccess(true).setMsg("删除id为"+id+"的书籍成功！");
        return r;
    }

    public static<T> Result<T> deleteFail(Integer id){
        Result<T> r = new Result<>();
        r.setSuccess(true).setMsg("删除id为"+id+"的书籍失败！");
        return r;
    }

}
