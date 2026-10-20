package com.codefactory.dev_social_network.consultas.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.codefactory.dev_social_network.consultas.interfaces.FollowedAuthorsPort;

import jakarta.persistence.EntityManager;

@Component
public class FollowedAuthorsAdapter implements FollowedAuthorsPort {

    private final EntityManager entityManager;

    public FollowedAuthorsAdapter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UUID> findFollowedIds(UUID userId) {
        return entityManager.createQuery(
                        "select f.followedId from UserFollowEntity f where f.followerId = :followerId",
                        UUID.class)
                .setParameter("followerId", userId)
                .getResultList();
    }
}