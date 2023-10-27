package com.example.band_notify.kafka;

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
    private Integer num = 0;

    @KafkaListener(topics = TopicConfig.communityNotify)
    public void listen(CommunityRequest communityRequest) {
//        System.out.println("consumer : " + communityRequest);
        System.out.println(num++);
        notifyService.sendNotify(communityRequest);
    }


}
