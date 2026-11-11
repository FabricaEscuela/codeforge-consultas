package com.codefactory.dev_social_network.consultas.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record FeedItem(
        FeedItemType type,
        UUID sourceId,
        String title,
        UUID authorId,
        OffsetDateTime createdAt) {
}