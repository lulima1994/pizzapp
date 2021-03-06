package com.picolli.pepperone.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Sabor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = false)
    private boolean salgada;
    @OneToMany(mappedBy = "sabor")
    private List<IngredienteSabor> ingredientes = new ArrayList<>();
}