package com.jogoscrud.diamond.jogoscrud.controllers;

import com.jogoscrud.diamond.jogoscrud.domain.jogo.Jogo;
import com.jogoscrud.diamond.jogoscrud.domain.jogo.JogoRepository;
import com.jogoscrud.diamond.jogoscrud.domain.jogo.RequestGame;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class JogosController {
    @Autowired
    private JogoRepository repository;
    @GetMapping
    public ResponseEntity getAllGamers(){
        var allGamers = repository.findAllByActiveTrue();
        return ResponseEntity.ok(allGamers);
    }

    @PostMapping
    public ResponseEntity registerGame(@RequestBody @Valid RequestGame data){
        Jogo newJogo = new Jogo(data);
        System.out.println(data);
        repository.save(newJogo);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public  ResponseEntity updateGame(@RequestBody @Valid RequestGame data){
        System.out.println(data);
        Optional<Jogo> optionalJogo = repository.findById(data.id());

        if(optionalJogo.isPresent()) {
            System.out.println("optional OK OK OOKOK OKOKOK");
            Jogo jogo = optionalJogo.get();
            jogo.setName(data.name());
            jogo.setDescricao(data.descricao());
            jogo.setGenero(data.genero());
            jogo.setWebsite(data.website());
            jogo.setDataLancamento(Date.valueOf(data.dataLancamento()));
            jogo.setDesenvolvedor_codigo(data.desenvolvedor_codigo());


        }else {
            System.out.println("NÃO ENCONTROU O ID");
            return ResponseEntity.notFound().build();
        }

        return null;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteGame(@PathVariable Long id){

//        repository.deleteById(id);
//        return ResponseEntity.noContent().build();

        Optional<Jogo> optionalJogo = repository.findById(id);
        if(optionalJogo.isPresent()) {
            System.out.println("optional OK OK OOKOK OKOKOK");
            Jogo jogo = optionalJogo.get();
            jogo.setActive(false);
        }else {
            System.out.println("NÃO ENCONTROU O ID");
            return ResponseEntity.notFound().build();
        }


        return null;
    }

}
