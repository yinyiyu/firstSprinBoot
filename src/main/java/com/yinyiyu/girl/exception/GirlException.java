package com.yinyiyu.girl.exception;

import com.yinyiyu.girl.enums.ResultEnum;

public class GirlException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code =resultEnum.getCode();
    }
}
