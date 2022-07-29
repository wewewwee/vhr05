package com.qf.hui.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseResult<T> {
    private String msg;
    private Integer status;
    private String tip;
    private T data;

    private ResponseResult() {
    }

    public static <T> ResponseResult<T> success(T data) {
        return success(ResponseEnumCode.SUCCESS, data);
    }

    public static <T> ResponseResult<T> success(ResponseEnumCode responseEnumCode, T data) {
        return getResponseResult(responseEnumCode, data);
    }


    public static <T> ResponseResult<T> error() {
        return error(ResponseEnumCode.ERROR);
    }

    public static <T> ResponseResult<T> error(ResponseEnumCode responseEnumCode) {
        return error(responseEnumCode, null);
    }

    public static <T> ResponseResult<T> error(ResponseEnumCode responseEnumCode, T errorData) {
        return getResponseResult(responseEnumCode, errorData);
    }

    private static <T> ResponseResult<T> getResponseResult(ResponseEnumCode responseEnumCode, T data) {
        return new ResponseResultBuilder<T>().msg(responseEnumCode.getMsg()).status(responseEnumCode.getStatus()).data(data).tip(responseEnumCode.getTip()).build();
    }
}
