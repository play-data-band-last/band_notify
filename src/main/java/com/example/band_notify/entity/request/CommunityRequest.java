package com.example.band_notify.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityRequest {
    private Long memberId;
    private String memberRole;
    private String memberName;
    private String memberImage;
    private String communityName;
    private String communityImage;
    private Long communityId;

}