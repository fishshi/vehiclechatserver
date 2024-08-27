package com.vehiclechatserver.websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.vehiclechatserver.utils.JwtUtils;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ServerEndpoint(value = "/chat/{token}")
@Component
public class WebSocketService {
    private static AtomicInteger connectionNum = new AtomicInteger(0);
    private static CopyOnWriteArraySet<WebSocketService> connectionSet = new CopyOnWriteArraySet<>();
    private static final String systemMessage = "系统消息：";

    private Session session;
    private String username;

    public void sendMessage(String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) throws IOException {
        try {
            username = (String) JwtUtils.parseJwt(token).get("username");
        } catch (Exception e) {
            session.close();
        }
        this.session = session;
        connectionSet.add(this);
        connectionNum.getAndIncrement();
        sendMessage(systemMessage + this.username + "连接成功");
        log.info(this.username + "连接成功");
        sendMessage(systemMessage + "当前在线" + connectionNum.get() + "人");
        log.info("当前在线" + connectionNum.get() + "人");
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        connectionNum.getAndDecrement();
        log.info(this.username + "断开连接");
        connectionSet.remove(this);
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        // sendMessage(systemMessage + "收到");
        for (WebSocketService service : connectionSet) {
            if (service != this) {
                service.sendMessage(this.username + "：" + message);
            }
        }
        log.info(this.username + "：" + message);
    }
}
