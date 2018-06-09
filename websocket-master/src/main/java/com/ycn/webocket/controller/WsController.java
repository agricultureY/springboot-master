package com.ycn.webocket.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.ycn.webocket.constant.Constant;
import com.ycn.webocket.entity.WiselyMessage;
import com.ycn.webocket.entity.WiselyResponse;
import com.ycn.webocket.service.WebSocketService;

@Controller
public class WsController {
	@Resource
    WebSocketService webSocketService;

    @MessageMapping(Constant.FORETOSERVERPATH)//@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
    @SendTo(Constant.PRODUCERPATH)//如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。
    public WiselyResponse say(WiselyMessage message) throws Exception {
        List<String> users = new ArrayList<>();
        users.add("d892bf12bf7d11e793b69c5c8e6f60fb");//此处写死只是为了方便测试,此值需要对应页面中订阅个人消息的userId
        webSocketService.send2Users(users, new WiselyResponse("测试点对点发送"));

        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }
}
