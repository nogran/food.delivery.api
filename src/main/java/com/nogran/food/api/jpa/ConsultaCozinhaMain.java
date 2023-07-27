package com.nogran.food.api.jpa;

import com.nogran.food.api.FoodDeliveryApplication;
import com.nogran.food.api.domain.model.Cozinha;
import com.nogran.food.api.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodDeliveryApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
        List<Cozinha> todasCozinhas = cozinhas.listar();

        for (Cozinha cozinha : todasCozinhas) {
            System.out.println(cozinha.getNome());
        }
    }
}
