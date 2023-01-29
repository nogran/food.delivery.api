package food.delivery.api.jpa;

import food.delivery.api.FoodDeliveryApplication;
import food.delivery.api.domain.model.Kitchen;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodDeliveryApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
        List<Kitchen> kitchens = cadastroCozinha.list();

        for (Kitchen kitchen : kitchens) {
            System.out.println(kitchen.getName());
        }
    }
}
