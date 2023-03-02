package com.nogran.food.api.domain.repository;

import com.nogran.food.api.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> todas();

    Restaurante porId(Long id);

    Restaurante adicionar(Restaurante restaurante);

    void remover(Restaurante restaurante);
}