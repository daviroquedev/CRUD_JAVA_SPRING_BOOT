package com.jogoscrud.diamond.jogoscrud.domain.jogo.Jogo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JogoDTO {
    private Long id;

    @NotBlank
    private String name;
    private String descricao;
    private Date dataLancamento;
    private String website;
    private Integer desenvolvedor_codigo;
    private String genero;
    private String urlCapa;
    private List<Integer> console_codigo;
    private boolean active = true;

    public JogoDTO(Long id, String name, String descricao, Date dataLancamento, String website, Integer desenvolvedor_codigo, String genero, String urlCapa, List<Integer> console_codigo) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.dataLancamento = dataLancamento;
        this.website = website;
        this.desenvolvedor_codigo = desenvolvedor_codigo;
        this.genero = genero;
        this.urlCapa = urlCapa;
        this.console_codigo = console_codigo;
        System.out.println("CONSOLECODIGO DTO"+ console_codigo);
    }


}