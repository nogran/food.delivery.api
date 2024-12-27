package com.nogran.food.domain.service;

import com.nogran.food.domain.exception.EntidadeEmUsoException;
import com.nogran.food.domain.exception.EntidadeNaoEncontradaException;
import com.nogran.food.domain.model.Restaurante;
import com.nogran.food.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante salvar(Restaurante restaurante) {
        return restauranteRepository.salvar(restaurante);
    }

    public List<Restaurante> listar() {
        return restauranteRepository.listar();
    }

    public Restaurante buscarPorId(Long id) {
        return restauranteRepository.buscarPorId(id);
    }

    public void remover(Long id) {
        try {
            restauranteRepository.remover(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Restaurante de codigo %d nao encontrada", id));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Restaurante de codigo %d nao pode ser removida pois esta em uso", id));
        }
    }
}