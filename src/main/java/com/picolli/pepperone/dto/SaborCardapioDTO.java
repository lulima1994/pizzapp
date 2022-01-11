package com.picolli.pepperone.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaborCardapioDTO {
    private Integer idSabor;
    private Integer idCardapio;
    private BigDecimal preco;
}
