package com.jogoscrud.diamond.jogoscrud.domain.jogo.Console;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Table(name = "console")
@Entity(name = "console")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Console {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String nome;

    @Column(name = "data_lancamento")
    private Date dataLancamento;

    private String empresa;

    public Console(String nome, Date dataLancamento, String empresa) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.empresa = empresa;

    }

    public Console(String nome, String s, String empresa) {
    }
}
