package com.vvnocode.car.service.core.websocket;

import lombok.Data;

@Data
public class WSMessage<T> {

    private String eventType;

    private T data;
}
