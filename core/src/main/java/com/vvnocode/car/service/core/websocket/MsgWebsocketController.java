package com.vvnocode.car.service.core.websocket;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/ws")
@Controller
@Slf4j
@ConditionalOnBean(MyEventHandler.class)
public class MsgWebsocketController {

    @Autowired
    private MyEventHandler myEventHandler;

    @OnOpen
    public void onOpen(Session session) {
        // 先鉴权，如果鉴权通过则存储WebsocketSession，否则关闭连接，这里省略了鉴权的代码
        System.out.println("session open. ID:" + session.getId());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("session close. ID:" + session.getId());
    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.debug("get client msg. ID: {} , . msg: {}", session.getId(), message);
        if (JSON.isValid(message)) {
            WSMessage wsMessage = JSON.parseObject(message, WSMessage.class);
            myEventHandler.detailEvent(wsMessage);
        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}
