package com.jogoscrud.diamond.jogoscrud.domain.jogo.Jogo;

import com.jogoscrud.diamond.jogoscrud.domain.jogo.JogoConsole.JogoConsole;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Table(name="jogo")
@Entity(name="jogo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Jogo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String descricao;

    private java.sql.Date dataLancamento;

    private String website;

    private Integer desenvolvedor_codigo;

    private String genero;

    private String urlCapa;

    private Boolean active;

    @ElementCollection
    @CollectionTable(name = "jogo_console", joinColumns = @JoinColumn(name = "jogo_id"))
    @Column(name = "console_codigo")
    private List<Integer> console_codigo;

    public Jogo(RequestGame requestGame){
        this.name = requestGame.name();
        this.dataLancamento = Date.valueOf(requestGame.dataLancamento());
        this.descricao = requestGame.descricao();
        this.genero = requestGame.genero();
        this.desenvolvedor_codigo = requestGame.desenvolvedor_codigo();
        this.console_codigo= requestGame.console_codigo();
        this.urlCapa = requestGame.urlCapa();
        this.website = requestGame.website();
        this.active = true;
    }


    public void setConsoleCodigos(List<JogoConsole> jogoConsoles) {

    }
}
