package org.learning.pizzeriacrud.repository;

import org.learning.pizzeriacrud.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
    
}
