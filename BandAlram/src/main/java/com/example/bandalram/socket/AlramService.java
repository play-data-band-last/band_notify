package com.example.bandalram.socket;


import com.example.bandalram.kafka.dto.CommunityJoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AlramService {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public void returnCommunityJoinAlam(CommunityJoinDto communityJoinDto){
        simpMessagingTemplate.convertAndSend(
                "/topic/"+ communityJoinDto.getTargetMemberId(),
                communityJoinDto);
    }

}
