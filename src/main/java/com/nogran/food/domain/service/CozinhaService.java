package com.nogran.food.domain.service;

import com.nogran.food.domain.exception.EntidadeEmUsoException;
import com.nogran.food.domain.exception.EntidadeNaoEncontradaException;
import com.nogran.food.domain.model.Cozinha;
import com.nogran.food.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public List<Cozinha> listar() {
        return cozinhaRepository.findAll();
    }

    public Optional<Cozinha> buscarPorId(Long id) {
        return cozinhaRepository.findById(id);
    }

    public void remover(Long id) {
        try {
            cozinhaRepository.removeById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Cozinha de codigo %d nao encontrada", id));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Cozinha de codigo %d nao pode ser removida pois esta em uso", id));
        }
    }
}
