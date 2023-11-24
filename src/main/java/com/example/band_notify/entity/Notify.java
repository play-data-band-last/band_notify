package com.example.band_notify.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "notifys",indexes = {
        @Index(name = "communityIdIndenx",columnList = "communityId"),
        @Index(name = "memberIdIndenx",columnList = "memberId")})
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notify {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long communityId;
    private long memberId;
    private long ownerId;
    private String memberName;
    private String communityName;
    private String memberProfileImg;
    private String message;
    private LocalDateTime currTime;


    //  1 : 커뮤니티 가입 공지
    private Integer flag;

    // 예약 발송용 필드
    @Column(nullable = true)
    private LocalDateTime scheduledTime;

    private boolean isRead;
}
