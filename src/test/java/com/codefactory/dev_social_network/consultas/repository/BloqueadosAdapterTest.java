package com.codefactory.dev_social_network.consultas.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.codefactory.dev_social_network.consultas.dto.BloqueadoItem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ExtendWith(MockitoExtension.class)
class BloqueadosAdapterTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Object[]> query;

    @InjectMocks
    private BloqueadosAdapter adapter;

    @Test
    void findByBlockerIdMapeaIdNombreYUsername() {
        UUID blockerId = UUID.randomUUID();
        UUID blockedId = UUID.randomUUID();

        when(entityManager.createQuery(anyString(), eq(Object[].class))).thenReturn(query);
        when(query.setParameter("blockerId", blockerId)).thenReturn(query);
        when(query.getResultList()).thenReturn(List.<Object[]>of(
                new Object[] {blockedId, "Luis Dev", "LuisDev"}));

        List<BloqueadoItem> resultado = adapter.findByBlockerId(blockerId);

        assertThat(resultado).containsExactly(new BloqueadoItem(blockedId, "Luis Dev", "LuisDev"));
    }

    @Test
    void findByBlockerIdDevuelveListaVaciaSinBloqueados() {
        UUID blockerId = UUID.randomUUID();

        when(entityManager.createQuery(anyString(), eq(Object[].class))).thenReturn(query);
        when(query.setParameter("blockerId", blockerId)).thenReturn(query);
        when(query.getResultList()).thenReturn(List.of());

        assertThat(adapter.findByBlockerId(blockerId)).isEmpty();
    }
}
