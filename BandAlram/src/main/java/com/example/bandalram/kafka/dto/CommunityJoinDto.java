package com.example.bandalram.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommunityJoinDto {
    private Long JoinMemberId;
    private String JoinMemberImage;
    private String JoinMemberName;
    private Long targetMemberId;
    private String communityName;
}
