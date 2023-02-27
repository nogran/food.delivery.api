package com.nogran.food.api.infrastructure.repository;

import com.nogran.food.api.domain.model.Cozinha;
import com.nogran.food.api.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> todas() {
        return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    @Override
    public Cozinha porId(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Override
    @Transactional
    public Cozinha adicionar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Override
    @Transactional
    public void remover(Cozinha cozinha) {
        cozinha = porId(cozinha.getId());
        manager.remove(cozinha);
    }
}
