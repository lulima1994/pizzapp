package com.picolli.pepperone.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, length = 45)
    private String senha;
    @Column(nullable = false, length = 45)
    private String email;
}
