package com.example.band_notify.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "notifys")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notify {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String message;

    @Column(nullable = true)
    private LocalDateTime scheduledTime;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isRead;
}
