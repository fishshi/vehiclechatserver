package com.vehiclechatserver.websocket;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.vehiclechatserver.utils.JwtUtils;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat/{token}")
@Component
public class WebSocketService {
    private static int numConnections = 0;

    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) throws IOException {
        try {
            JwtUtils.parseJwt(token);
        } catch (Exception e) {
            session.close();
        }
        ++numConnections;
        session.getBasicRemote().sendText("连接成功");
        session.getBasicRemote().sendText("当前在线" + numConnections + "人");
        System.out.println("WebSocket opened");
    }

    @OnClose
    public void onClose(Session session) {
        --numConnections;
        System.out.println("WebSocket closed");
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        session.getBasicRemote().sendText("收到");
    }
}
