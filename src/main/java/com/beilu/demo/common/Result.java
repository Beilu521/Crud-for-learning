package main.java.com.beilu.demo.common;

import lombok.Data;

/**
 * 全局统一返回结果封装类
 */
@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    /**
     * 成功返回（带数据）
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    /**
     * 成功返回（无数据，如删除成功）
     */
    public static <T> Result<T> success() {
        return success(null);
    }

    /**
     * 失败返回（自定义状态码和信息）
     */
    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 失败返回（默认500服务器错误）
     */
    public static <T> Result<T> error(String msg) {
        return error(500, msg);
    }
}