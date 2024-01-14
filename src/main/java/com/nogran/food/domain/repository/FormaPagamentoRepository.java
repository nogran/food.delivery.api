package com.nogran.food.domain.repository;

import com.nogran.food.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {

    List<FormaPagamento> todas();

    FormaPagamento porId(Long id);

    FormaPagamento adicionar(FormaPagamento formaPagamento);

    void remover(FormaPagamento formaPagamento);
}
