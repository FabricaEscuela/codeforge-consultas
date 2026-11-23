package com.codefactory.dev_social_network.consultas.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.codefactory.dev_social_network.consultas.dto.BloqueadoItem;
import com.codefactory.dev_social_network.consultas.interfaces.BloqueadosPort;

@ExtendWith(MockitoExtension.class)
class ListarBloqueadosUseCaseImplTest {

    @Mock
    private BloqueadosPort bloqueadosPort;

    @InjectMocks
    private ListarBloqueadosUseCaseImpl useCase;

    @Test
    void bloqueadosDeDelegaEnElPuerto() {
        UUID usuarioId = UUID.randomUUID();
        List<BloqueadoItem> esperado = List.of(
                new BloqueadoItem(UUID.randomUUID(), "Luis Dev", "LuisDev"));

        when(bloqueadosPort.findByBlockerId(usuarioId)).thenReturn(esperado);

        assertThat(useCase.bloqueadosDe(usuarioId)).isEqualTo(esperado);
    }
}
