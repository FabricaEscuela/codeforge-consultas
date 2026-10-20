package com.codefactory.dev_social_network.consultas.entity;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "discussions")
public class Discussion {

    @Id
    private Long id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    protected Discussion() {
    }
}