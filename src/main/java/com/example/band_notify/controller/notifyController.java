package com.example.band_notify.controller;

import com.example.band_notify.entity.Notify;
import com.example.band_notify.service.NotifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notify")
@CrossOrigin("*")
public class notifyController {
    private final NotifyService notifyService;

    @MessageMapping("/hello")
    @SendTo("/topic/notify")
    public void sendNotify(Notify notify) {
        // 클라에서 소켓통신으로 보내면 처리해주는 곳 인데 일단 필요없긴 할 듯.. ?
    }

//    @GetMapping("{memberId}")
//    public Page<Notify> findAllByMemberId(
//            @PathVariable Long memberId,
//            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
//            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size
//    ){
//        return notifyService.findAllByMemberId(memberId, PageRequest.of(page,size));
//    }

//    @PostMapping("/community")
//    public Page<Notify> findAllByCommunityId(
//            @RequestBody List<Long> communityIds,
//            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
//            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size
//    ){
//        System.out.println(communityIds);
//        return notifyService.findByAllCommunityId(communityIds, PageRequest.of(page,size));
//    }

    @GetMapping("/community/{ownerId}")
    public List<Notify> findAllByOwnerId(@PathVariable Long ownerId){
        return notifyService.findAllByOwnerId(ownerId);
    }

    @PostMapping("/chageRead/{notifyId}")
    public void changeRead(@PathVariable Long notifyId) {
        notifyService.changeMemberRead(notifyId);
    }

}

