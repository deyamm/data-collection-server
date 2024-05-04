package com.exchange.sys.utils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

@Data
public class ResponseBody<T> {
    // pageNum
    protected long code;

    // message;
    protected String message;

    // data
    protected T data;

    public ResponseBody() {};

    public ResponseBody(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果 
     * @param data 获取的数据
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> success(T data) {
        return new ResponseBody<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     * @param message 提示信息
     * @param data 获取的数据
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> success(String message, T data) {
        return new ResponseBody<T>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> failed(ReErrorCode errorCode) {
        return new ResponseBody<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     *
     * @param errorCode
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> failed(ReErrorCode errorCode, String message) {
        return new ResponseBody<T>(errorCode.getCode(), message, null);
    }

    /**
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> failed(String message) {
        return new ResponseBody<T>(ResponseCode.FAILED.getCode(), message, null);
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> failed() {
        return failed(ResponseCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> validateFailed() {
        return failed(ResponseCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> validateFailed(String message) {
        return new ResponseBody<T>(ResponseCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> unauthorized(T data) {
        return new ResponseBody<T>(ResponseCode.UNAUTHORIZED.getCode(), ResponseCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseBody<T> forbidden(T data) {
        return new ResponseBody<T>(ResponseCode.FORBIDDEN.getCode(), ResponseCode.FORBIDDEN.getMessage(), data);
    }
}
