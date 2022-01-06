package com.picolli.pepperone.dto;

import com.picolli.pepperone.domain.model.Cardapio;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

@Data
public class SaborCardapioDTO {
    private Integer idSabor;
    private Integer idCardapio;
    private BigDecimal preco;
}
