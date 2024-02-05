package com.jogoscrud.diamond.jogoscrud.domain.jogo.Jogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface JogoRepository extends JpaRepository <Jogo, Long> {
    List<Jogo> findByNameContainingIgnoreCase(String name);

    List<Jogo> findAllByActiveTrue();

}
