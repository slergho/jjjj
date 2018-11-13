package com.example.login.exception;

import com.example.login.enums.ResultEnum;
import lombok.Getter;

@Getter
public class PersonException extends RuntimeException {

    private Integer code;

    public PersonException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public PersonException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
