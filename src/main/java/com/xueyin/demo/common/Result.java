package com.xueyin.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private int code;
    private String message;
    private Object data;

    //请求成功
    public static Result success(int code,String message,Object data){
        return new Result(code,message,data);
    }
    public static Result success(String message,Object data){
        return new Result(200,message,data);
    }
    public static Result success(String message){
        return new Result(200,message,null);
    }
}
