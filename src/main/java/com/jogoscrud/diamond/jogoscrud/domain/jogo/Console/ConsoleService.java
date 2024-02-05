package com.jogoscrud.diamond.jogoscrud.domain.jogo.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsoleService {

    private final ConsoleRepository consoleRepository;

    @Autowired
    public ConsoleService(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    public List<Console> getAllConsoles() {
        return consoleRepository.findAll();
    }

    public Optional<Console> getConsoleById(Integer id) {
        return consoleRepository.findById(id);
    }

    public Console createConsole(Console console) {
        return consoleRepository.save(console);
    }

    public Optional<Console> updateConsole(Integer id, Console console) {
        if (consoleRepository.existsById(id)) {
            console.setCodigo(id);
            return Optional.of(consoleRepository.save(console));
        } else {
            return Optional.empty();
        }
    }

    public void deleteConsole(Integer id) {
        consoleRepository.deleteById(id);
    }

    public List<Console> searchConsolesByName(String name) {
        return consoleRepository.findAllByNomeContainingIgnoreCase(name);
    }


}