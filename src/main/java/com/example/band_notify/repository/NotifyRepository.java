package com.example.band_notify.repository;

import com.example.band_notify.entity.Notify;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotifyRepository extends JpaRepository<Notify, Long> {
    Page<Notify> findAllByMemberId(Long memberId,PageRequest pageRequest);


    @Query("select new com.example.band_notify.entity.Notify(c.id, c.ownerId, c.communityId , c.memberId, c.memberName, c.communityName, c.memberProfileImg, c.message, c.currTime, c.flag, c.scheduledTime, c.isRead ) " +
            "from Notify c " +
            "where c.ownerId in :ownerId and c.isRead = false " +
            "order by c.currTime ")
    List<Notify> findAllByOwnerId(@Param("ownerId")Long ownerId);

}
