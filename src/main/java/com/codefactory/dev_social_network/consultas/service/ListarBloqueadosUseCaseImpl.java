package com.codefactory.dev_social_network.consultas.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codefactory.dev_social_network.consultas.dto.BloqueadoItem;
import com.codefactory.dev_social_network.consultas.interfaces.BloqueadosPort;
import com.codefactory.dev_social_network.consultas.interfaces.ListarBloqueadosUseCase;

@Service
public class ListarBloqueadosUseCaseImpl implements ListarBloqueadosUseCase {

    private final BloqueadosPort bloqueadosPort;

    public ListarBloqueadosUseCaseImpl(BloqueadosPort bloqueadosPort) {
        this.bloqueadosPort = bloqueadosPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BloqueadoItem> bloqueadosDe(UUID usuarioId) {
        return bloqueadosPort.findByBlockerId(usuarioId);
    }
}
