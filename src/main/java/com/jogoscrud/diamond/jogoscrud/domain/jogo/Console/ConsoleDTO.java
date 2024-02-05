package com.jogoscrud.diamond.jogoscrud.domain.jogo.Console;//package com.jogoscrud.diamond.jogoscrud.domain.jogo.Console;


import jakarta.persistence.Column;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.sql.Date;

@Setter
@Getter
@Data
public class ConsoleDTO{

    private Integer codigo;

    private String nome;


    private Date dataLancamento;

    private String empresa;

    public ConsoleDTO(Console console) {
        BeanUtils.copyProperties(console, this);
    }

    public ConsoleDTO(){

    }

}