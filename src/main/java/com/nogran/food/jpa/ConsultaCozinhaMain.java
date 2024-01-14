package com.nogran.food.jpa;

import com.nogran.food.FoodDeliveryApplication;
import com.nogran.food.domain.model.Cozinha;
import com.nogran.food.domain.repository.CozinhaRepository;
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
