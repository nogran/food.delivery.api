package com.nogran.food.domain.repository;

import com.nogran.food.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    Optional<Cozinha> findById(Long id);

    Optional<Cozinha> findByNome(String nome);

    void removeById(Long id);

}
