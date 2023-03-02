package com.nogran.food.api.domain.repository;

import com.nogran.food.api.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> todas();

    Permissao porId(Long id);

    Permissao adicionar(Permissao permissao);

    void remover(Permissao permissao);
}
