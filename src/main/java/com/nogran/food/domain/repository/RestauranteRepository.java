package com.nogran.food.domain.repository;

import com.nogran.food.domain.model.Cozinha;
import com.nogran.food.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();

    List<Cozinha> consultarPorNome(String nome);

    Restaurante buscarPorId(Long id);

    Restaurante salvar(Restaurante restaurante);

    void remover(Long id);
}
