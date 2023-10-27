package com.example.band_notify.controller;

import com.example.band_notify.entity.Notify;
import com.example.band_notify.service.NotifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class notifyController {
    private final NotifyService notifyService;

    @MessageMapping("/hello")
    @SendTo("/topic/notify")
    public void sendNotify(Notify notify) {
        // 클라에서 소켓통신으로 보내면 처리해주는 곳 인데 일단 필요없긴 할 듯.. ?
    }
}