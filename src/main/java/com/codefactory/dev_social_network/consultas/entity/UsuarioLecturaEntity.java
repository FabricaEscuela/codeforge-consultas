package com.codefactory.dev_social_network.consultas.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Mapeo de solo lectura de la tabla usuarios (la escribe codeforge-administracion).
 */
@Entity
@Table(name = "usuarios")
public class UsuarioLecturaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "username", length = 50)
    private String username;

    protected UsuarioLecturaEntity() {
    }
}
