package com.nogran.food.api.domain.repository;

import com.nogran.food.api.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();

    Estado porId(Long id);

    Estado adicionar(Estado estado);

    void remover(Estado estado);
}
