package com.nogran.food.domain.repository;

import com.nogran.food.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> todas();

    Cidade porId(Long id);

    Cidade adicionar(Cidade cidade);

    void remover(Cidade cidade);
}
