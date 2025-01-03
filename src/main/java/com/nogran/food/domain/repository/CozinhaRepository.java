package com.nogran.food.domain.repository;

import com.nogran.food.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> listar();

    Cozinha buscarPorId(Long id);

    Cozinha salvar(Cozinha cozinha);

    void remover(Long id);
}
