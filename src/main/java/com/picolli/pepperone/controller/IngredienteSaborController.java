package com.picolli.pepperone.controller;

import com.picolli.pepperone.domain.model.Ingrediente;
import com.picolli.pepperone.domain.model.IngredienteSabor;
import com.picolli.pepperone.domain.model.Sabor;
import com.picolli.pepperone.domain.repository.IngredienteRepository;
import com.picolli.pepperone.domain.repository.IngredienteSaborRepository;
import com.picolli.pepperone.domain.repository.SaborRepository;
import com.picolli.pepperone.dto.IngredienteSaborDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class IngredienteSaborController {

    private final IngredienteSaborRepository ingredienteSaborRepository;
    private final SaborRepository saborRepository;
    private final IngredienteRepository ingredienteRepository;

    @PutMapping("/sabor/ingrediente")
    public void adicionar(@RequestBody IngredienteSaborDTO ingredienteSaborDTO) {
        IngredienteSabor ingredienteSabor = new IngredienteSabor();
        Sabor sabor = saborRepository.findById(ingredienteSaborDTO.getIdSabor()).orElseThrow();
        Ingrediente ingrediente = ingredienteRepository.findById(ingredienteSaborDTO.getIdIngrediente()).orElseThrow();
        ingredienteSabor.setSabor(sabor);
        ingredienteSabor.setIngrediente(ingrediente);
        ingredienteSaborRepository.save(ingredienteSabor);
    }

    @DeleteMapping("/sabor/{idSabor}/ingrediente/{idIngrediente}")
    public void deletar(@PathVariable Integer idSabor, @PathVariable Integer idIngrediente) {
        IngredienteSabor ingredienteSabor = ingredienteRepository
                .findByIdSaborAndIdIngrediente(idSabor, idIngrediente)
                .orElseThrow();

        ingredienteSaborRepository.delete(ingredienteSabor);
    }
}
