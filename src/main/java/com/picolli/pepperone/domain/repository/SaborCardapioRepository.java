package com.picolli.pepperone.domain.repository;

import com.picolli.pepperone.domain.model.SaborCardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SaborCardapioRepository extends JpaRepository<SaborCardapio, Integer> {

    @Query("select sc from SaborCardapio sc where sc.cardapio.id = :idCardapio and sc.sabor.id = :idSabor")
    Optional<SaborCardapio> findByIdCardapioAndIdSabor(Integer idCardapio, Integer idSabor);
}
