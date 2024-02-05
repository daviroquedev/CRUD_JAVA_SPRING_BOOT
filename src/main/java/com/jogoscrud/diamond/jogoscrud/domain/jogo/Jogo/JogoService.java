package com.jogoscrud.diamond.jogoscrud.domain.jogo.Jogo;

import com.jogoscrud.diamond.jogoscrud.domain.jogo.Console.Console;
import com.jogoscrud.diamond.jogoscrud.domain.jogo.Console.ConsoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogoService {
    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private ConsoleRepository consoleRepository;

    public List<JogoDTO> getAllGames() {
        return jogoRepository.findAllByActiveTrue().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public void registerGame(JogoDTO jogoDTO) {
        jogoDTO.setActive(true);
        Jogo jogo = new Jogo(jogoDTO);

        jogoRepository.save(jogo);
    }

    public void updateGame(Long id, JogoDTO jogoDTO) {
        Jogo existingJogo = jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game not found with id: " + id));

        // Copiar propriedades do DTO para a entidade, excluindo o ID
        BeanUtils.copyProperties(jogoDTO, existingJogo, "id");

        // Salvar a entidade atualizada
        jogoRepository.save(existingJogo);
    }
    public void deleteGame(Long id) {
        Jogo existingJogo = jogoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game not found with id: " + id));
        existingJogo.setActive(false);
        jogoRepository.save(existingJogo);
    }

    public List<JogoDTO> searchGamesByName(String name) {
        return jogoRepository.findByNameContainingIgnoreCase(name).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // cascade delete

    private JogoDTO convertToDTO(Jogo jogo) {
        return new JogoDTO(jogo.getId(),jogo.getName(), jogo.getDescricao(), jogo.getDataLancamento(),
                jogo.getWebsite(), jogo.getDesenvolvedor_codigo(), jogo.getGenero(), jogo.getUrlCapa(),
                jogo.getConsole_codigo().stream().map(Console::getCodigo).collect(Collectors.toList()));
    }


}
