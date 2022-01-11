package com.picolli.pepperone.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Data
public class SaborCardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private BigDecimal preco;
    @ManyToOne
    @JoinColumn(name = "id_sabor")
    @ToString.Exclude
    private Sabor sabor;
    @ManyToOne
    @JoinColumn(name = "id_cardapio")
    @JsonIgnore
    @ToString.Exclude
    private Cardapio cardapio;
}