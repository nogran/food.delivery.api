package food.delivery.api.jpa;

import food.delivery.api.domain.model.Kitchen;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastroCozinha {
    @PersistenceContext
    private EntityManager manager;

    public List<Kitchen> list() {
        return manager.createQuery("from Kitchen", Kitchen.class)
                .getResultList();
    }
}
