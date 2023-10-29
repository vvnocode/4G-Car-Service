package com.vvnocode.car.service.core.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult<T> {

    private String code;

    private String msg;

    private T data;

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>("0", "success", data);
    }

    public static <T> BaseResult<T> error(T data) {
        return new BaseResult<>("-1", "error", data);
    }
}
