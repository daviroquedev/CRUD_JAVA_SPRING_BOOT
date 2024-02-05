package com.jogoscrud.diamond.jogoscrud.domain.jogo.Console;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsoleRepository extends JpaRepository<Console, Integer> {

    List<Console> findAllByNomeContainingIgnoreCase(String name);
}
