package com.picolli.pepperone.controller;

import com.picolli.pepperone.domain.model.Sabor;
import com.picolli.pepperone.domain.repository.SaborRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SaborController {

    private final SaborRepository saborRepository;

    @PostMapping("/sabor")
    public void salvar(@RequestBody Sabor sabor) {
        saborRepository.save(sabor);
    }

    @GetMapping("/sabor/{id}")
    public Sabor buscarID(@PathVariable Integer id) {
        Sabor sabor = saborRepository.findById(id).orElse(null);
        System.out.println(sabor);
        return sabor;
    }

    @GetMapping("/sabor")
    public Page<Sabor> buscarPage(Pageable pageable) {
        Page<Sabor> sabor = saborRepository.findAll(pageable);
        System.out.println(sabor);
        return sabor;
    }

    @DeleteMapping("/sabor/{id}")
    public void deletarID(@PathVariable Integer id) {
        saborRepository.deleteById(id);
    }
}
