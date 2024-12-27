package com.nogran.food.infrastructure.repository;

import com.nogran.food.domain.model.Cidade;
import com.nogran.food.domain.repository.CidadeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> listar() {
        return manager.createQuery("from Cidade", Cidade.class).getResultList();
    }

    @Override
    public Cidade buscarPorId(Long id) {
        return manager.find(Cidade.class, id);
    }

    @Override
    @Transactional
    public Cidade adicionar(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Override
    @Transactional
    public void remover(Long id) {
        Cidade cidade = buscarPorId(id);
        manager.remove(cidade);
    }
}
