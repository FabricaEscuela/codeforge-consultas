package com.codefactory.dev_social_network.consultas.interfaces;

import java.util.List;
import java.util.UUID;

import com.codefactory.dev_social_network.consultas.dto.BloqueadoItem;

public interface BloqueadosPort {

    List<BloqueadoItem> findByBlockerId(UUID blockerId);
}
