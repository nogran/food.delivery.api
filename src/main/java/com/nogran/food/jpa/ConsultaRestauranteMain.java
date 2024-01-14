package com.nogran.food.jpa;

import com.nogran.food.FoodDeliveryApplication;
import com.nogran.food.domain.model.Restaurante;
import com.nogran.food.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodDeliveryApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
        List<Restaurante> todosRestaurantes = restaurantes.todas();

        for (Restaurante restaurante : todosRestaurantes) {
            System.out.printf("%s - %.2f - %s\n", restaurante.getNome(),
                    restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
        }
    }
}
