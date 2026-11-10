package com.codefactory.dev_social_network.consultas.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "seguidores")
@IdClass(UserFollowId.class)
public class UserFollowEntity {

    @Id
    @Column(name = "id_seguidor", nullable = false)
    private UUID followerId;

    @Id
    @Column(name = "id_seguido", nullable = false)
    private UUID followedId;

    protected UserFollowEntity() {
    }
}