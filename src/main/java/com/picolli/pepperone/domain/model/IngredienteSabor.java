package com.picolli.pepperone.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class IngredienteSabor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    @ToString.Exclude
    private Ingrediente ingrediente;

    @ManyToOne
    @JoinColumn(name = "id_sabor")
    @JsonIgnore
    @ToString.Exclude
    private Sabor sabor;
}
