package com.picolli.pepperone.controller;

import com.picolli.pepperone.domain.model.Cardapio;
import com.picolli.pepperone.domain.repository.CardapioRepository;
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
public class CardapioController {

    private final CardapioRepository cardapioRepository;

    @PostMapping("/cardapio")
    public void salvar(@RequestBody Cardapio cardapio) {
        cardapioRepository.save(cardapio);
    }

    @GetMapping("/cardapio/{id}")
    public Cardapio buscarID(@PathVariable Integer id) {
        Cardapio cardapio = cardapioRepository.findById(id).orElse(null);
        System.out.println(cardapio);
        return cardapio;
    }

    @GetMapping("/cardapio")
    public Page<Cardapio> buscarPage(Pageable pageable) {
        Page<Cardapio> cardapio = cardapioRepository.findAll(pageable);
        System.out.println(cardapio);
        return cardapio;
    }

    @DeleteMapping("/cardapio/{id}")
    public void deletarID(@PathVariable Integer id) {
        cardapioRepository.deleteById(id);
    }
}
