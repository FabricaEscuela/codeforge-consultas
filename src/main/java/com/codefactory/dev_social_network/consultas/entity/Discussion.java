package com.codefactory.dev_social_network.consultas.entity;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "discusiones")
public class Discussion {

    @Id
    private UUID id;

    @Column(name = "autor_id", nullable = false)
    private UUID userId;

    @Column(name = "titulo", nullable = false, length = 150)
    private String title;

    @Column(name = "fecha_creacion", nullable = false)
    private OffsetDateTime createdAt;

    protected Discussion() {
    }
}