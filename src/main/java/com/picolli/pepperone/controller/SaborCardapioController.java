package com.picolli.pepperone.controller;

import com.picolli.pepperone.domain.model.Cardapio;
import com.picolli.pepperone.domain.model.Sabor;
import com.picolli.pepperone.domain.model.SaborCardapio;
import com.picolli.pepperone.domain.repository.CardapioRepository;
import com.picolli.pepperone.domain.repository.SaborCardapioRepository;
import com.picolli.pepperone.domain.repository.SaborRepository;
import com.picolli.pepperone.dto.SaborCardapioDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SaborCardapioController {

    private final SaborCardapioRepository saborCardapioRepository;
    private final CardapioRepository cardapioRepository;
    private final SaborRepository saborRepository;

    @PutMapping("/cardapio/sabor")
    public void adicionar(@RequestBody SaborCardapioDTO saborCardapioDTO) {
        SaborCardapio saborCardapio = new SaborCardapio();
        Cardapio cardapio = cardapioRepository.findById(saborCardapioDTO.getIdCardapio()).orElseThrow();
        Sabor sabor = saborRepository.findById(saborCardapioDTO.getIdSabor()).orElseThrow();
        saborCardapio.setPreco(saborCardapioDTO.getPreco());
        saborCardapio.setCardapio(cardapio);
        saborCardapio.setSabor(sabor);
        saborCardapioRepository.save(saborCardapio);
    }

    @DeleteMapping("/cardapio/{idCardapio}/sabor/{idSabor}")
    public void deletar(@PathVariable Integer idCardapio, @PathVariable Integer idSabor) {
        SaborCardapio saborCardapio = saborCardapioRepository
                .findByIdCardapioAndIdSabor(idCardapio, idSabor)
                .orElseThrow();

        saborCardapioRepository.delete(saborCardapio);
    }
}
