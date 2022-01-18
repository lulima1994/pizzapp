package com.picolli.pepperone.domain.repository;

import com.picolli.pepperone.domain.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
}
