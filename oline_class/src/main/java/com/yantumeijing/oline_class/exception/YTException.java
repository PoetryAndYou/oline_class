package com.yantumeijing.oline_class.exception;

/**
 * 自定义异常类
 */
public class YTException extends RuntimeException {

    private Integer code;

    private String msg;

    public YTException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {

        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
