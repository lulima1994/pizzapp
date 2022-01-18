package com.picolli.pepperone.domain.repository;

import com.picolli.pepperone.domain.model.IngredienteSabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IngredienteSaborRepository extends JpaRepository<IngredienteSabor, Integer> {

    @Query("select ir from IngredienteSabor ir where ir.sabor.id = :idSabor and ir.ingrediente.id = :idIngrediente")
    Optional<IngredienteSabor> findByIdSaborAndIdIngrediente(Integer idSabor, Integer idIngrediente);
}
