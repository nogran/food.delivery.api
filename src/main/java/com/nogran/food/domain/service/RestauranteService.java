package com.nogran.food.domain.service;

import com.nogran.food.domain.exception.EntidadeEmUsoException;
import com.nogran.food.domain.exception.EntidadeNaoEncontradaException;
import com.nogran.food.domain.model.Cozinha;
import com.nogran.food.domain.model.Restaurante;
import com.nogran.food.domain.repository.CozinhaRepository;
import com.nogran.food.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
        if (cozinha.isEmpty()) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de cozinha com código %d", cozinhaId));
        }
        restaurante.setCozinha(cozinha.get());
        return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> listar() {
        return restauranteRepository.findAll();
    }

    public Optional<Restaurante> buscarPorId(Long id) {
        return restauranteRepository.findById(id);
    }

    public void remover(Long id) {
        try {
            restauranteRepository.removeById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Restaurante de codigo %d nao encontrada", id));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Restaurante de codigo %d nao pode ser removida pois esta em uso", id));
        }
    }
}
