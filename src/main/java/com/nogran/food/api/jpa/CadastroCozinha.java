package com.nogran.food.api.jpa;

import com.nogran.food.api.domain.model.Cozinha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastroCozinha {
    @PersistenceContext
    private EntityManager manager;

    public List<Cozinha> list() {
        return manager.createQuery("from Cozinha", Cozinha.class)
                .getResultList();
    }
}
