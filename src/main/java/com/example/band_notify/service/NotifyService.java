package com.example.band_notify.service;

import com.example.band_notify.entity.request.CommunityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotifyService {
    private final SimpMessageSendingOperations sendingOperations;


    public void sendNotify(CommunityRequest communityRequest) {
        System.out.println("/topic/notify/" + communityRequest.getCommunityId());
        sendingOperations.convertAndSend("/topic/notify/community/"+communityRequest.getCommunityId(), communityRequest);
    }
}
