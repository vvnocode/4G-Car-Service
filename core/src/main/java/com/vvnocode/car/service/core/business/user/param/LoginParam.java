package com.vvnocode.car.service.core.business.user.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginParam {

    @NotBlank
    private String user;
    @NotBlank
    private String pwd;
}
