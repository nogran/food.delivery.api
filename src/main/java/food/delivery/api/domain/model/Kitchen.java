package food.delivery.api.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Objects;

@Entity
@Table
@Data
public class Kitchen {
    @Id
    private Long id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kitchen kitchen = (Kitchen) o;
        return id.equals(kitchen.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
