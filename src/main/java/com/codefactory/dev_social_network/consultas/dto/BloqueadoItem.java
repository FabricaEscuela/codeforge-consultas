package com.codefactory.dev_social_network.consultas.dto;

import java.util.UUID;

public record BloqueadoItem(
        UUID usuarioId,
        String nombre,
        String username) {
}
