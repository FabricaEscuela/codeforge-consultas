package com.codefactory.dev_social_network.consultas.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.codefactory.dev_social_network.consultas.dto.BloqueadoItem;
import com.codefactory.dev_social_network.consultas.interfaces.BloqueadosPort;

import jakarta.persistence.EntityManager;

@Component
public class BloqueadosAdapter implements BloqueadosPort {

    private final EntityManager entityManager;

    public BloqueadosAdapter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<BloqueadoItem> findByBlockerId(UUID blockerId) {
        List<Object[]> rows = entityManager.createQuery(
                        "select b.blockedId, u.nombre, u.username "
                      + "from UsuarioBloqueadoEntity b, UsuarioLecturaEntity u "
                      + "where u.id = b.blockedId and b.blockerId = :blockerId "
                      + "order by b.fechaBloqueo desc", Object[].class)
                .setParameter("blockerId", blockerId)
                .getResultList();

        return rows.stream()
                .map(r -> new BloqueadoItem(
                        (UUID) r[0],
                        (String) r[1],
                        (String) r[2]))
                .toList();
    }
}
