package com.liuwohe.communitymis.data;


import com.liuwohe.communitymis.Constant.Constant;
import lombok.Data;

//全局返回类型
@Data
public class Result {
    private Integer code;
    private String status;
    private Object data;

    public Result(Integer code, String status) {
        this.code = code;
        this.status = status;
    }

    public Result(Integer code, String status, Object data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }


    //定制成功返回模板
    public static Result success(){
        return new Result(Constant.SUCCESS_CODE,Constant.SUCCESS_STATUS);
    }

    //定制成功返回模板
    public static Result success(Object data){
        return new Result(Constant.SUCCESS_CODE,Constant.SUCCESS_STATUS,data);
    }

    //定制失败返回模板
    public static Result failed(){
        return new Result(Constant.FAILED_CODE,Constant.FAILED_STATUS);
    }

    //定制失败返回模板
    public static Result failed(Object data){
        return new Result(Constant.FAILED_CODE,Constant.FAILED_STATUS,data);
    }
}
