package com.jogoscrud.diamond.jogoscrud.domain.jogo.Console;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consoles")
public class ConsoleController {

    @Autowired
    private ConsoleRepository consoleRepository;

    @GetMapping
    public ResponseEntity<Object> getAllConsoles() {
        List<Console> consoles = consoleRepository.findAll();
        return ResponseEntity.ok(consoles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Console> getConsoleById(@PathVariable Integer id) {
        Optional<Console> consoleOptional = consoleRepository.findById(id);
        if (consoleOptional.isPresent()) {
            return ResponseEntity.ok(consoleOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Console> createConsole(@RequestBody @Valid Console console) {
        Console createdConsole = consoleRepository.save(console);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConsole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Console> updateConsole(@PathVariable Integer id, @RequestBody @Valid Console console) {
        if (consoleRepository.existsById(id)) {
            console.setCodigo(id);
            Console updatedConsole = consoleRepository.save(console);
            return ResponseEntity.ok(updatedConsole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsole(@PathVariable Integer id) {
        consoleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}