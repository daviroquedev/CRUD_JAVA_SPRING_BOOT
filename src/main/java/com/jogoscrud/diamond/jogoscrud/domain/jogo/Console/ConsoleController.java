package com.jogoscrud.diamond.jogoscrud.domain.jogo.Console;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consoles")
@RequiredArgsConstructor
public class ConsoleController {

    private final ConsoleService consoleService;

    @GetMapping
    public ResponseEntity<List<Console>> getAllConsoles() {
        List<Console> consoles = consoleService.getAllConsoles();
        return ResponseEntity.ok(consoles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Console> getConsoleById(@PathVariable Integer id) {
        Optional<Console> consoleOptional = consoleService.getConsoleById(id);
        return consoleOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Console> createConsole(@RequestBody @Valid Console console) {
        Console createdConsole = consoleService.createConsole(console);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConsole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Console> updateConsole(@PathVariable Integer id, @RequestBody @Valid Console console) {
        Optional<Console> updatedConsole = consoleService.updateConsole(id, console);
        return updatedConsole.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsole(@PathVariable Integer id) {
        consoleService.deleteConsole(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Console>> searchConsolesByName(@RequestParam String name) {
        List<Console> consoles = consoleService.searchConsolesByName(name);
        return ResponseEntity.ok(consoles);
    }
}