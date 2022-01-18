package com.picolli.pepperone.domain.repository;

import com.picolli.pepperone.domain.model.Ingrediente;
import com.picolli.pepperone.domain.model.IngredienteSabor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
    Optional<IngredienteSabor> findByIdSaborAndIdIngrediente(Integer idSabor, Integer idIngrediente);
}
