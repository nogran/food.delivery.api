package com.nogran.food.domain.repository;

import com.nogran.food.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    void removeById(Long cidadeId);
}
