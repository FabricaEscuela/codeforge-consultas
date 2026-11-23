package com.codefactory.dev_social_network.consultas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codefactory.dev_social_network.consultas.dto.BloqueadoItem;
import com.codefactory.dev_social_network.consultas.interfaces.ListarBloqueadosUseCase;
import com.codefactory.dev_social_network.shared.config.CurrentUserPort;

@RestController
@RequestMapping("/api/v1/bloqueados")
public class BloqueadosController {

    private final ListarBloqueadosUseCase listarBloqueadosUseCase;
    private final CurrentUserPort currentUserPort;

    public BloqueadosController(ListarBloqueadosUseCase listarBloqueadosUseCase,
                                CurrentUserPort currentUserPort) {
        this.listarBloqueadosUseCase = listarBloqueadosUseCase;
        this.currentUserPort = currentUserPort;
    }

    @GetMapping
    public ResponseEntity<List<BloqueadoItem>> bloqueados() {
        List<BloqueadoItem> bloqueados = listarBloqueadosUseCase.bloqueadosDe(currentUserPort.currentUserId());
        return ResponseEntity.ok(bloqueados);
    }
}
