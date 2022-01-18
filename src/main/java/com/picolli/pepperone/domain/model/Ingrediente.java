package com.picolli.pepperone.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String nome;
}
