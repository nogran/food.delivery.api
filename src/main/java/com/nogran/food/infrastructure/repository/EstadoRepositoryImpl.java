package com.nogran.food.infrastructure.repository;

import com.nogran.food.domain.model.Estado;
import com.nogran.food.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listar() {
        return manager.createQuery("from Estado", Estado.class)
                .getResultList();
    }

    @Override
    public Estado buscarPorId(Long id) {
        return manager.find(Estado.class, id);
    }

    @Transactional
    @Override
    public Estado adicionar(Estado estado) {
        return manager.merge(estado);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        Estado estado = buscarPorId(id);
        if (estado == null) {
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(estado);
    }
}
