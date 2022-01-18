package com.picolli.pepperone.controller;

import com.picolli.pepperone.domain.model.Ingrediente;
import com.picolli.pepperone.domain.repository.IngredienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class IngredienteController {

    private final IngredienteRepository ingredienteRepository;

    @PostMapping("/ingrediente")
    public void salvar(@RequestBody Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
    }

    @GetMapping("/ingrediente/{id}")
    public Ingrediente buscarID(@PathVariable Integer id) {
        Ingrediente ingrediente = ingredienteRepository.findById(id).orElse(null);
        System.out.println(ingrediente);
        return ingrediente;
    }

    @GetMapping("/ingrediente")
    public Page<Ingrediente> buscarPage(Pageable pageable) {
        Page<Ingrediente> ingrediente = ingredienteRepository.findAll(pageable);
        System.out.println(ingrediente);
        return ingrediente;
    }

    @DeleteMapping("/ingrediente/{id}")
    public void deletarID(@PathVariable Integer id) {
        ingredienteRepository.deleteById(id);
    }
}
