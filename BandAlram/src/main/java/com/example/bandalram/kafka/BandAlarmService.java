package com.example.bandalram.kafka;


import com.example.bandalram.kafka.dto.CommunityJoinDto;
import com.example.bandalram.socket.AlramService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BandAlarmService {
    private final AlramService alramService;



//    @RetryableTopic
//    @KafkaListener(topics = TopicConfig.memberDelete)
//    public void memberDeleteListener(MemberUpdateRequest memberUpdateRequest) {
//        boardService.deleteMemberHandler(memberUpdateRequest.getMemberId());
//    }


    @RetryableTopic
    @KafkaListener(topics = TopicConfig.socketServer2)
    public void CommunityJoinListener(CommunityJoinDto communityJoinDto){
        alramService.returnCommunityJoinAlam(communityJoinDto);
    }

    @DltHandler
    public void processDltMessage(String dltMessage) {
        // DLT 토픽에서 메시지를 처리합니다. (예: 로깅 또는 추가 조사)
        System.out.println("DLT에서 메시지 수신: " + dltMessage);
    }

}
