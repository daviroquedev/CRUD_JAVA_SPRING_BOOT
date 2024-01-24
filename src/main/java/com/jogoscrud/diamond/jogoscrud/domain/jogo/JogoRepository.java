package com.jogoscrud.diamond.jogoscrud.domain.jogo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository <Jogo, Long> {
    List<Jogo> findAllByActiveTrue();
}
