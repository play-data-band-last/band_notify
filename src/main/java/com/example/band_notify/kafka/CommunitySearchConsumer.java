package com.example.band_notify.kafka;

import com.example.band_notify.entity.Notify;
import com.example.band_notify.entity.request.CommunityRequest;
import com.example.band_notify.service.NotifyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunitySearchConsumer {
    private final NotifyService notifyService;
    private Integer num0 = 0;
    private Integer num1 = 0;
    private Integer num2 = 0;

    @KafkaListener(topics = TopicConfig.communityNotify0)
    public void listenA(Notify notify) {
        num0++;
        System.out.println("consumer-notify0 합계 : " + num0);
        notifyService.sendNotifyCommunityInsert(notify);
    }

//    @KafkaListener(topics = TopicConfig.communityNotify1)
//    public void listenB(CommunityRequest communityRequest) {
////        System.out.println("consumer : " + communityRequest);
//        num1++;
//        System.out.println("consumer-notify1 합계 : " + num1);
//        notifyService.sendNotifyCommunityInsert(communityRequest);
//    }

//    @KafkaListener(topics = TopicConfig.communityNotify2)
//    public void listenC(CommunityRequest communityRequest) {
//        num2++;
//        System.out.println("consumer-notify2 합계 : " + num2);
//        notifyService.sendNotifyCommunityInsert(communityRequest);
//    }


}
