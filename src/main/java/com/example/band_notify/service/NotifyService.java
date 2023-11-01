package com.example.band_notify.service;

import com.example.band_notify.entity.request.CommunityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.MessageDeliveryException;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotifyService {
    private final SimpMessageSendingOperations sendingOperations;
    private final RedisTemplate<String, Object> redisTemplate;
    private int num = 0;

    public void sendNotify(CommunityRequest communityRequest) {
        Long communityId = communityRequest.getCommunityId();

         //get data for redis..
//        List<Long> byCommunityIdFromRedis = findByCommunityIdFromRedis(String.valueOf(communityId));
//
//        for (Long userId :byCommunityIdFromRedis) {
//            num++;
//            try {
//                System.out.println("프론트소켓으로 가는 합계(유저리스트for) :  " + num);
//                sendingOperations.convertAndSend("/topic/notify/userId/" + userId, communityRequest);
//            } catch (MessageDeliveryException e) {
//                // 에러가 발생한 경우 로그를 출력하거나 예외를 처리할 수 있음
//                System.err.println("메시지 전송 중 에러 발생: " + e.getMessage());
//                // 예외를 던지거나 특정 에러 응답을 반환하는 등의 처리 가능
//            }
//        }
        sendingOperations.convertAndSend("/topic/notify/community/" + communityRequest.getCommunityId(), communityRequest);


    }

    public List<Long> findByCommunityIdFromRedis(String communityId) {
        HashOperations<String, String, List<Long>> hashOps = redisTemplate.opsForHash();
        List<Long> existingList = hashOps.get("community-"+communityId, "communityList");
        return existingList != null ? existingList : new ArrayList<>();
    }
}
