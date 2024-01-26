package com.jogoscrud.diamond.jogoscrud.domain.jogo.Jogo;

import com.jogoscrud.diamond.jogoscrud.domain.jogo.Jogo.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository <Jogo, Long> {
    List<Jogo> findByNameContainingIgnoreCase(String name);

    List<Jogo> findAllByActiveTrue();


}
