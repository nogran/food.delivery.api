package com.nogran.food.domain.repository;

import com.nogran.food.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> todas();

    Permissao porId(Long id);

    Permissao adicionar(Permissao permissao);

    void remover(Permissao permissao);
}
