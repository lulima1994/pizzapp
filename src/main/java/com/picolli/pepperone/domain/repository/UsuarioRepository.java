package com.picolli.pepperone.domain.repository;

import com.picolli.pepperone.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
