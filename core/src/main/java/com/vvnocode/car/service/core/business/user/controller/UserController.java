package com.vvnocode.car.service.core.business.user.controller;

import com.vvnocode.car.service.core.business.user.param.LoginParam;
import com.vvnocode.car.service.core.common.dto.BaseResult;
import com.vvnocode.car.service.core.config.PropertiesConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

@Slf4j
@RestController
@Validated
@RequestMapping("user")
public class UserController {

    @Autowired
    private PropertiesConfig propertiesConfig;

    @PostMapping("login")
    public BaseResult<Boolean> login(@RequestBody @Valid LoginParam param) {
        String pwd = propertiesConfig.getUser().get(param.getUser());
        return BaseResult.success(Objects.equals(pwd, param.getPwd()));
    }
}
