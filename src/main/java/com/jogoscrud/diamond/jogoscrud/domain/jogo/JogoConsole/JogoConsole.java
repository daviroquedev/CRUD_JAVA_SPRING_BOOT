package com.jogoscrud.diamond.jogoscrud.domain.jogo.JogoConsole;

import com.jogoscrud.diamond.jogoscrud.domain.jogo.Jogo.Jogo;
import com.jogoscrud.diamond.jogoscrud.domain.jogo.Console.Console;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jogo_console")
public class JogoConsole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    @ManyToOne
    @JoinColumn(name = "console_codigo")
    private Console console;

    public void setConsole(Integer consoleCodigo) {
    }
}
