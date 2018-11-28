package com.example.learn.utils;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String msg;

    private T data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
