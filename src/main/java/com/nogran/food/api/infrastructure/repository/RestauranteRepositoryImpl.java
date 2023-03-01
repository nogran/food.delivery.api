package com.nogran.food.api.infrastructure.repository;

import com.nogran.food.api.domain.model.Restaurante;
import com.nogran.food.api.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> todas() {
        return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
    }

    @Override
    public Restaurante porId(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Override
    @Transactional
    public Restaurante adicionar(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Override
    @Transactional
    public void remover(Restaurante restaurante) {
        restaurante = porId(restaurante.getId());
        manager.remove(restaurante);
    }
}
