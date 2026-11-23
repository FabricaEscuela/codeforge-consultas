package com.codefactory.dev_social_network.consultas.entity;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Mapeo de solo lectura de la tabla usuarios_bloqueados.
 * La escritura del bloqueo pertenece a codeforge-administracion.
 */
@Entity
@Table(name = "usuarios_bloqueados")
public class UsuarioBloqueadoEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "blocker_id", nullable = false)
    private UUID blockerId;

    @Column(name = "blocked_id", nullable = false)
    private UUID blockedId;

    @Column(name = "fecha_bloqueo", nullable = false)
    private OffsetDateTime fechaBloqueo;

    protected UsuarioBloqueadoEntity() {
    }
}
