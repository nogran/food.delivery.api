package com.nogran.food.domain.service;

import com.nogran.food.domain.exception.EntidadeEmUsoException;
import com.nogran.food.domain.exception.EntidadeNaoEncontradaException;
import com.nogran.food.domain.model.Cidade;
import com.nogran.food.domain.model.Estado;
import com.nogran.food.domain.repository.CidadeRepository;
import com.nogran.food.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Cidade> listar() {
        return cidadeRepository.listar();
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRepository.buscarPorId(id);
    }

    public Cidade adicionar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.buscarPorId(estadoId);
        if (estado == null) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de estado com código %d", estadoId));
        }
        cidade.setEstado(estado);
        return cidadeRepository.adicionar(cidade);
    }

    public void remover(Long cidadeId) {
        try {
            cidadeRepository.remover(cidadeId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com código %d", cidadeId));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
        }
    }

}
