package com.jogoscrud.diamond.jogoscrud.domain.jogo.Jogo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
@RequiredArgsConstructor
public class JogosController {


    private final JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<JogoDTO>> getAllGames() {
        List<JogoDTO> allGames = jogoService.getAllGames();
        return ResponseEntity.ok(allGames);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<JogoDTO> registerGame(@RequestBody @Valid JogoDTO jogoDTO) {
        jogoService.registerGame(jogoDTO);
        System.out.println("JOGO DTO"+jogoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> updateGame(@PathVariable Long id, @RequestBody @Valid JogoDTO jogoDTO) {
        jogoService.updateGame(id, jogoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        jogoService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<JogoDTO>> searchGamesByName(@RequestParam String name) {
        List<JogoDTO> games = jogoService.searchGamesByName(name);
        return ResponseEntity.ok(games);
    }
}
