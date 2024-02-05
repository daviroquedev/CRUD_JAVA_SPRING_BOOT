package com.jogoscrud.diamond.jogoscrud.domain.jogo.Jogo;

import com.jogoscrud.diamond.jogoscrud.domain.jogo.Console.Console;
import com.jogoscrud.diamond.jogoscrud.domain.jogo.JogoConsole.JogoConsole;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Table(name = "jogo")
@Entity(name = "jogo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String descricao;
    private Date dataLancamento;
    private String website;
    private Integer desenvolvedor_codigo;
    private String genero;
    private String urlCapa;
    private Boolean active;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(
            name = "jogo_console",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "console_codigo"))
    private List<Console> console_codigo;

    public Jogo(JogoDTO jogoDTO) {
        this.name = jogoDTO.getName();
        this.dataLancamento = jogoDTO.getDataLancamento();
        this.descricao = jogoDTO.getDescricao();
        this.genero = jogoDTO.getGenero();
        this.desenvolvedor_codigo = jogoDTO.getDesenvolvedor_codigo();
        this.console_codigo = jogoDTO.getConsole_codigo()
                .stream()
                .map(c -> Console.builder().codigo(c).build())
                .collect(Collectors.toList());

        this.urlCapa = jogoDTO.getUrlCapa();
        this.website = jogoDTO.getWebsite();
        this.active = jogoDTO.isActive();
    }
    public void setJogoConsoles(List<JogoConsole> jogoConsoles) {
        System.out.println("CONSOLE CODIGO1 "+console_codigo);
    }
}