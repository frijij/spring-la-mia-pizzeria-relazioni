package org.learning.pizzeriacrud.repository;

import org.learning.pizzeriacrud.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
