package com.nogran.food.domain.repository;

import com.nogran.food.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();

    Estado buscarPorId(Long id);

    Estado adicionar(Estado estado);

    void remover(Long id);
}
